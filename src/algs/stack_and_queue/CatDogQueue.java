package algs.stack_and_queue;

//考察实现特殊数据结构的能力以及针对特殊功能设计算法的能力

import java.util.LinkedList;
import java.util.Queue;

/**
 * 有一个重要的时间戳概念需要记住
 */
public class CatDogQueue {
    public static class Pet {
        private String type;

        public Pet(String type) {
            this.type = type;
        }

        public String getPetType() {
            return this.type;
        }
    }

    public static class Dog extends Pet {
        public Dog() {
            super("dog");
        }
    }

    public static class Cat extends Pet {
        public Cat() {
            super("cat");
        }
    }

    //用户不能改变原始数据结构，需要自定义一个数据结构
    public static class PetEnterQueue{
        private Pet pet;
        private int id; //时间戳，表示入列的顺序

        public PetEnterQueue(Pet pet, int id) {
            this.pet = pet;
            this.id = id;
        }

        public Pet getPet() {
            return pet;
        }

        public int getId() {
            return id;
        }
        public String getType(){
            return pet.getPetType();
        }
    }

    public static class MyCatDogQueue{
        private Queue<PetEnterQueue> catQueue;
        private Queue<PetEnterQueue> dogQueue;
        private int id;
        public MyCatDogQueue() {
            catQueue = new LinkedList<PetEnterQueue>();
            dogQueue = new LinkedList<PetEnterQueue>();
            id = 0;
        }

        public void add(Pet pet){
            if (pet.getPetType().equals("cat")){
                catQueue.add(new PetEnterQueue(pet, this.id++));
            }else {
                dogQueue.add(new PetEnterQueue(pet, this.id++));
            }
        }


    }
}
