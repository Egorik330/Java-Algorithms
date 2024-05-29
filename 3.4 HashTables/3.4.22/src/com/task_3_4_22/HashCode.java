package com.task_3_4_22;

public class HashCode {
   
    public class Point2D {
        private final int x;
        private final int y;
    
        public Point2D(int x, int y) {
            this.x = x;
            this.y = y;
        }
    
        @Override
        public int hashCode() {
            int result = 17;
            result = 31 * result + x;
            result = 31 * result + y;
            return result;
        }
    }

    public class Interval {
        private final int min;
        private final int max;
    
        public Interval(int min, int max) {
            this.min = min;
            this.max = max;
        }
    
        @Override
        public int hashCode() {
            int result = 17;
            result = 31 * result + min;
            result = 31 * result + max;
            return result;
        }

        public class Interval2D {
            private final Interval x;
            private final Interval y;
        
            public Interval2D(Interval x, Interval y) {
                this.x = x;
                this.y = y;
            }
        
            @Override
            public int hashCode() {
                int result = 17;
                result = 31 * result + x.hashCode();
                result = 31 * result + y.hashCode();
                return result;
            }
        }
    }

    public class Date {
        private final int year;
        private final int month;
        private final int day;
    
        public Date(int year, int month, int day) {
            this.year = year;
            this.month = month;
            this.day = day;
        }
    
        @Override
        public int hashCode() {
            int result = 17;
            result = 31 * result + year;
            result = 31 * result + month;
            result = 31 * result + day;
            return result;
        }
    }
}