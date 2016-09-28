import java.util.*;

/**
 * Created by zaclee on 9/28/16.
 */
public class PhoneBook {

    Map<String, List<String>> list;

    public PhoneBook() {
        list = new HashMap<String, List<String>>();
    }

    public void addContact(String name, String phoneNum) {
        List<String> phoneNumbers = new ArrayList<String>();
        phoneNumbers.add(phoneNum);
        list.put(name.toLowerCase(),phoneNumbers);
    }

    public void addNumber(String name, String phoneNum) {
        for(String str : list.keySet()){
            if(str.equalsIgnoreCase(name)) {
                list.get(name).add(phoneNum);
            }
        }
    }

    public void removeNumber(String name, String phoneNum) {
        for(String str : list.keySet()) {
            if(str.equalsIgnoreCase(name)) {
                Iterator<String> it = list.get(name).iterator();
                while(it.hasNext()) {
                    if(it.next().equalsIgnoreCase(phoneNum)){
                        it.remove();
                    }
                }
            }
        }
    }

    public String removeRecord(String name) {
        for(String str : list.keySet()) {
            if(str.equalsIgnoreCase(name)) {
                list.remove(name);
                return "This record " + name + " has been removed";
            }
        }
        return "This record doesn't exist.";
    }

    public void removeContact(String name) {
        list.remove(name.toLowerCase());
    }

    public String lookup(String name) {
        List<String> temp = list.get(name.toLowerCase());
        return temp.toString();
    }

    public void viewNames() {
        for(String key : list.keySet()) {
            System.out.println("Name: " + key);
        }
    }

    public String reverseLookup(String num) {
        for(String str : list.keySet()) {
            if(list.get(str).contains(num)) {
                return str;
            }
        }
        return "Name not found";
    }

    public void viewAllInfo() {
        for(String key : list.keySet()) {
            System.out.println("Name: " + key);
//            List<String> temp = list.get(key).toString();
            System.out.println("Number: " + list.get(key).toString());
        }
    }

    public static void main(String[] args) {

    }
}
