package basic_data_structures.hashtables;

import basic_data_structures.list.Employee;

import java.util.*;

class ChainedHashtable{

    private LinkedList<StoredEmployee>[] hashTable;

    public ChainedHashtable(){
        hashTable = new LinkedList[10];
        for(int i=0; i< hashTable.length; i++){
            hashTable[i] = new LinkedList<StoredEmployee>();
        }
    }

    public void put(String key, Employee value){
        int hashedKey = hashKey(key);
        StoredEmployee addToTable = new StoredEmployee(key,value);
        hashTable[hashedKey].add(addToTable);
    }

    public Employee get(String key){
        int hashedKey = hashKey(key);
        ListIterator<StoredEmployee> iterator = hashTable[hashedKey].listIterator();
        StoredEmployee employee = null;
        while (iterator.hasNext()){
            employee = iterator.next();
            if(employee.key.equals(key)){
                return employee.employee;
            }
        }

        return null;
    }

    public Employee remove(String key){
        int hashedKey = hashKey(key);
        ListIterator<StoredEmployee> iterator = hashTable[hashedKey].listIterator();
        StoredEmployee employee = null;
        int index = -1;
        while (iterator.hasNext()){
            employee = iterator.next();
            index++;
            if(employee.key.equals(key)){
                break;
            }
        }

        if(employee == null){
            return null;
        }else {
            hashTable[hashedKey].remove(index);
            return employee.employee;
        }

    }

    private int hashKey(String key){
        return Math.abs( key.hashCode() % hashTable.length );
    }

    public void printHashtable(){
        for(int i=0; i<hashTable.length; i++){
            if(hashTable[i].isEmpty()){
                System.out.println("Empty Slot");
            }else {
                ListIterator<StoredEmployee> iterator = hashTable[i].listIterator();
                while (iterator.hasNext()){
                    System.out.print(iterator.next().employee);
                    System.out.print(" -> ");
                }
                System.out.println("NULL");
            }
        }
    }

};

public class SecondMethod {

    public static void main(String[] args) {

        Employee janeJones = new Employee("Jane","Jones",92192);
        Employee johnDoe = new Employee("John","Doe",342192);
        Employee marySmith = new Employee("Mary","Smith",587192);
        Employee steveSmith = new Employee("Steve","Smith",573792);
        Employee mikeWilson = new Employee("Mike","Wilson",92582);
        Employee billEnd = new Employee("Bill","End",92782);

        ChainedHashtable hashTable = new ChainedHashtable();
        hashTable.put("Jones", janeJones);
        hashTable.put("Doe", johnDoe);
        hashTable.put("Smith", marySmith);
        hashTable.put("Wilson", mikeWilson);
        hashTable.put("Steve", steveSmith);

        System.out.println("---------HashTable---------");
        hashTable.printHashtable();
        System.out.println("---------------------------");
        System.out.println("Value : " + hashTable.get("Jones"));
        System.out.println("Value : " + hashTable.get("End"));
        System.out.println("Value : " + hashTable.get("Doe"));
        System.out.println("Value : " + hashTable.get("Smith"));
        System.out.println("Value : " + hashTable.get("Steve"));
        System.out.println("Removed Steve Smith");
        hashTable.remove("Steve");
        System.out.println("---------HashTable---------");
        hashTable.printHashtable();
        System.out.println("---------------------------");


        String[] array = {"abc", "2", "10", "0"};
        List<String> list = Arrays.asList(array);
        Collections.sort(list);
        System.out.println(Arrays.toString(array));


    }
}
