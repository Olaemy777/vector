package com.olaemy;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Vector vector1 = new Vector(3, 5, 7);
        Vector vector2 = new Vector(4, 6, 5);
        System.out.println(vector1.length());
        System.out.println(vector2.length());
        System.out.println(vector1.scalarMultiply(vector2));
        System.out.println(vector1.vectorMultiply(vector2));
        System.out.println(vector1.cos(vector2));
        System.out.println(vector1.add(vector2));
        System.out.println(vector1.sub(vector2));
        System.out.println(Arrays.toString(Vector.random(3)));

    }
}
    class Vector {
        private final double x;
        private final double y;
        private final double z;

        public Vector(double x, double y, double z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }

        public double length() {
            return Math.sqrt(x * x + y * y + z * z);
        }

        public double scalarMultiply(Vector vector) {
            return x * vector.x + y * vector.y + z * vector.z;
        }

        public Vector vectorMultiply(Vector vector) {
            return new Vector(y * vector.z - z * vector.y,
                    z * vector.x - x * vector.z,
                    x * vector.y - y * vector.x);
        }

        public double cos(Vector vector) {
            return scalarMultiply(vector) / (length() * vector.length());
        }
        public Vector add(Vector vector){
            return new Vector(x+ vector.x,y+ vector.y,z+ vector.z);
        }
        public Vector sub(Vector vector){
            return new Vector(x- vector.x,y- vector.y,z- vector.z);
        }
        public static Vector[] random(int num){
            Vector[] array=new Vector[num];
            for (int i=0;i<num;i++){
                array[i]=new Vector(Math.random()*10,Math.random()*10,Math.random()*10);
            }
            return array;
        }

        @Override
        public String toString() {
            return "vector"+"("+"x="+x+" ,y="+y+" ,z="+z+")";
        }
    }


