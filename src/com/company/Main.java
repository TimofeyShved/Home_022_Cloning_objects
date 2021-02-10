package com.company;

public class Main {
    public static void main(String[] args) throws Exception {
        MyObject myObject = new MyObject(); // создали объекта i = 1
        myObject.i = 1;

        NewObject newObject2 = new NewObject(); // добавляем ему внутренний объект
        newObject2.j = 7;
        myObject.newObject = newObject2;

        MyObject myObject2 = myObject.clone(); //клонируем
        System.out.println("копируем ссылку на myObject");
        myObject2.i = 2;                //но так как он клонируется, то будет новый объект
        System.out.println("i = "+myObject.i);
        System.out.println("j = "+myObject.newObject.j);

        NewObject newObject = new NewObject();
        newObject.j = 3;                         // создали 2 объекта i = 1 и j =3
        myObject.newObject = newObject;  //закидываем j в myObject
        MyObject myObject1 = myObject.clone(); //клонируем
        myObject.i=2;
        System.out.println("глубокое клонирование");
        System.out.println("i = "+myObject.i);
        myObject1.newObject.j=4;
        System.out.println("j = "+myObject.newObject.j);
    }
}

// Мой объект
class MyObject implements Cloneable{
    int i;
    NewObject newObject;
    
    @Override
    protected MyObject clone() throws CloneNotSupportedException{
        MyObject myObject = (MyObject) super.clone(); // глубокое клонирование, так как иначе не скопирует
        myObject.newObject = newObject.clone();
        return myObject;
    }
}

// Новый объект
class NewObject implements Cloneable{ // имплементим интерфейс клонирования
    int j;
    
    @Override
    protected NewObject clone() throws CloneNotSupportedException{
        return (NewObject) super.clone(); // он склонирует все объекты класса в новый
    }
}