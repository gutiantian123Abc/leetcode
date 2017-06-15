package com.company;

import java.util.ArrayList;

/**
 * Created by xiangtiangu on 4/25/17.
 */
public class FileSystem {
    public abstract class Entry {
        protected String name;
        protected Directory parent_directory;
        public abstract long size();

        public Entry(String name, Directory parent_directory) {
            this.name = name;
            this.parent_directory = parent_directory;
        }

        public void rename(String name) {
            this.name = name;
        }

        public boolean delete() {
            if(parent_directory == null) {
                return false;
            }
            return parent_directory.deleteContent(this);
        }

        public String getName() {
            return name;
        }


        public String getFullPath() {
            if(parent_directory == null) {
                return name;
            }
            return parent_directory.getFullPath() + "/" + name;
        }

    }



    public class File extends Entry {
        private long size;
        private String content;

        public File(String name, Directory parent_directory, long size) {
            super(name, parent_directory);
            this.size = size;
        }

        public long size() {
            return size;
        }

        public void setSize(long size) {
            this.size = size;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content  = content;
        }
    }




    public class Directory extends Entry {
        ArrayList<Entry> contents;
        public Directory(String name, Directory parent_directory) {
            super(name, parent_directory);
            contents = new ArrayList<>();
        }

        public long size() {
            long size = 0;
            for(Entry content : contents) {
                size += content.size();
            }
            return size;
        }

        public boolean deleteContent(Entry child) {
            return contents.remove(child);
        }

        public void addContent(Entry child) {
            contents.add(child);
        }

        public ArrayList<Entry> getContents() {
            return contents;
        }

        public int num_of_file() {
            int num = 0;
            for(Entry content : contents) {
                if(content instanceof File) {
                    num += 1;
                }else {
                   num++;
                   Directory d = (Directory)content;
                   num += d.num_of_file();
                }
            }
            return num;
        }

    }


}
