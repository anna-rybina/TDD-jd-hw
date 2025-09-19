import com.github.annarybina.PhoneBook;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PhoneBookTest {

    @Test
    public void testAddSingleContact() {
        PhoneBook phoneBook = new PhoneBook();
        int result = phoneBook.add("Аня", "1234567890");
        assertEquals(1, result);
    }

    @Test
    public void testAddMultipleContacts() {
        PhoneBook phoneBook = new PhoneBook();
        phoneBook.add("Аня", "1234567890");
        int result = phoneBook.add("Слава", "0987654321");
        assertEquals(2, result);
    }

    @Test
    public void testAddDuplicateName() {
        PhoneBook phoneBook = new PhoneBook();
        phoneBook.add("Аня", "1234567890");
        int result = phoneBook.add("Аня", "9999999999");
        assertEquals(1, result);
    }
}
