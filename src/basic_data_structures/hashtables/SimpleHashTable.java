package basic_data_structures.hashtables;

import basic_data_structures.list.Employee;

class StoredEmployee{
    public String key;
    public Employee employee;

    public StoredEmployee(String key, Employee employee) {
        this.key = key;
        this.employee = employee;
    }
};

class MyHashTable{
    private StoredEmployee[] hashTable;

    public MyHashTable(){
        hashTable = new StoredEmployee[10];
    }

    private int hashKey(String key){
        return key.length() % hashTable.length;
    }

    private boolean isOccupied(int index){
        return hashTable[index] != null;
    }

    public void put(String key, Employee employee){
        int hashedKey = hashKey(key);
        if(isOccupied(hashedKey)){
            int stopIndex = hashedKey;
            if(hashedKey == hashTable.length - 1){
                hashedKey = 0;
            }else{
                hashedKey++;
            }

            while (isOccupied(hashedKey) && hashedKey != stopIndex){
                hashedKey = (hashedKey + 1) % hashTable.length;
            }
        }


        if(hashTable[hashedKey] != null){
            System.out.println("Already filled at " + hashedKey);
        }else{
            hashTable[hashedKey] = new StoredEmployee(key, employee);
        }
    }

    private int findKey(String key){
        int hashedKey = hashKey(key);
        if(hashTable[hashedKey] != null && hashTable[hashedKey].key.equals(key)){
            return hashedKey;
        }

        //use linear probing

        int stopIndex = hashedKey;
        if (hashedKey == hashTable.length - 1) {
            hashedKey = 0;
        } else {
            hashedKey++;
        }

        while (hashTable[hashedKey] != null && hashedKey != stopIndex && !hashTable[hashedKey].key.equals(key)) {
            hashedKey = (hashedKey + 1) % hashTable.length;
        }

        if(hashTable[hashedKey] != null && hashTable[hashedKey].key.equals(key)){
            return hashedKey;
        }else{
            return -1;
        }
    }

    public Employee get(String key){
        int hashedKey = findKey(key);
        if(hashedKey == -1){
            return null;
        }
        return hashTable[hashedKey].employee;
    }

    public Employee remove(String key){
        int hashedKey = findKey(key);
        if(hashedKey == -1) return null;

        Employee remove = hashTable[hashedKey].employee;
        hashTable[hashedKey] = null;

        StoredEmployee[] oldHashTable = hashTable;
        hashTable = new StoredEmployee[oldHashTable.length];
        for(int i=0; i< oldHashTable.length; i++){
            if(oldHashTable[i] != null){
                put(oldHashTable[i].key, oldHashTable[i].employee);
            }
        }

        return remove;
    }

    public void printHashtable() {
        for(StoredEmployee e : hashTable){
            if(e == null){
                System.out.println("Empty slot");
            }else{
                System.out.println(e.employee+" ");
            }

        }
    }

};

public class SimpleHashTable {

    public static void main(String[] args) {

        Employee janeJones = new Employee("Jane","Jones",92192);
        Employee johnDoe = new Employee("John","Doe",342192);
        Employee marySmith = new Employee("Mary","Smith",587192);
        Employee steveSmith = new Employee("Steve","Smith",573792);
        Employee mikeWilson = new Employee("Mike","Wilson",92582);
        Employee billEnd = new Employee("Bill","End",92782);

        MyHashTable hashTable = new MyHashTable();
        hashTable.put("Jones", janeJones);
        hashTable.put("Doe", johnDoe);
        hashTable.put("Smith", marySmith);
        hashTable.put("Wilson", mikeWilson);
        hashTable.put("End", billEnd);
        hashTable.put("Steve", steveSmith);

        System.out.println("---------HashTable---------");
        hashTable.printHashtable();
        System.out.println("---------------------------");
        System.out.println("Value : " + hashTable.get("Jones"));
        System.out.println("Value : " + hashTable.get("End"));
        System.out.println("Value : " + hashTable.get("Doe"));
        System.out.println("Value : " + hashTable.get("Smith"));
        System.out.println("Value : " + hashTable.get("Steve"));
        System.out.println("Removed Bill End");
        hashTable.remove("End");
        System.out.println("---------HashTable---------");
        hashTable.printHashtable();
        System.out.println("---------------------------");

    }
}
