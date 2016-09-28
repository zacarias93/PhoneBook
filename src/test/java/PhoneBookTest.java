import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class PhoneBookTest {

    PhoneBook phoneBook;

    @Before
    public void setUpTest() {
        phoneBook = new PhoneBook();
        phoneBook.addContact("zac","981-7411");
    }

    @Test
    public void addContactTest() { // checked viewNames as well + viewAllInfo
        phoneBook.addContact("chris","222-2222");
        phoneBook.addContact("ryan","566-5656");
        phoneBook.addNumber("zac","222-2222");
        phoneBook.viewNames();
        phoneBook.viewAllInfo();
        Assert.assertEquals("add 1 to phonebook", 3, phoneBook.list.size());
    }

    @Test
    public void addNumber() {
        phoneBook.addNumber("zac", "222-2222");
        Assert.assertEquals("add number to Zac", 2, phoneBook.list.get("zac").size());
    }

    @Test
    public void lookupTest() {
        phoneBook.addNumber("zac", "222-2222");
        Assert.assertEquals("look up zac's number", "[981-7411, 222-2222]", phoneBook.lookup("zac"));
    }

    @Test
    public void removeTest() {
        phoneBook.removeContact("zac");
        Assert.assertEquals("remove zac from phonebook", 0, phoneBook.list.size());
    }

    @Test
    public void reverseLookupTest() {
        phoneBook.addNumber("zac","222-2222");
        Assert.assertEquals("look up num - return name", "zac", phoneBook.reverseLookup("222-2222"));
    }

    @Test
    public void removeNumberTest() {
        phoneBook.addNumber("zac", "222-2222");
        phoneBook.removeNumber("zac","981-7411");
        Assert.assertEquals("remove number", "[222-2222]", phoneBook.lookup("zac"));
    }

    @Test
    public void removeRecordTest() {
        Assert.assertEquals("remove zac", "This record zac has been removed", phoneBook.removeRecord("zac"));
    }


}
