import com.github.annarybina.PhoneBook;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;

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

    @Test
    public void testFindByNumberExisting() {
        PhoneBook phoneBook = new PhoneBook();
        phoneBook.add("Аня", "1234567890");
        String result = phoneBook.findByNumber("1234567890");
        assertEquals("Аня", result);
    }

    @Test
    public void testFindByNumberNonExisting() {
        PhoneBook phoneBook = new PhoneBook();
        phoneBook.add("Аня", "1234567890");
        String result = phoneBook.findByNumber("9999999999");
        assertNull(result);
    }

    @Test
    public void testFindByNumberEmptyBook() {
        PhoneBook phoneBook = new PhoneBook();
        String result = phoneBook.findByNumber("1234567890");
        assertNull(result);
    }

    @Test
    public void testFindByNameExisting() {
        PhoneBook phoneBook = new PhoneBook();
        phoneBook.add("Аня", "1234567890");
        String result = phoneBook.findByName("Аня");
        assertEquals("1234567890", result);
    }

    @Test
    public void testFindByNameNonExisting() {
        PhoneBook phoneBook = new PhoneBook();
        phoneBook.add("Аня", "1234567890");
        String result = phoneBook.findByName("Слава");
        assertNull(result);
    }

    @Test
    public void testFindByNameEmptyBook() {
        PhoneBook phoneBook = new PhoneBook();
        String result = phoneBook.findByName("Аня");
        assertNull(result);
    }

    @Test
    public void testPrintAllNamesSingleContact() {
        PhoneBook phoneBook = new PhoneBook();
        phoneBook.add("Аня", "1234567890");

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        phoneBook.printAllNames();

        String output = outContent.toString().trim();
        assertEquals("Аня", output);
    }

    @Test
    public void testPrintAllNamesMultipleContacts() {
        PhoneBook phoneBook = new PhoneBook();
        phoneBook.add("Мия", "3333333333");
        phoneBook.add("Аня", "1111111111");
        phoneBook.add("Слава", "2222222222");

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        phoneBook.printAllNames();

        String output = outContent.toString().trim();
        List<String> names = Arrays.asList(output.split("\n"));
        assertEquals(Arrays.asList("Аня", "Слава", "Мия"), names);
    }

    @Test
    public void testPrintAllNamesEmptyBook() {
        PhoneBook phoneBook = new PhoneBook();

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        phoneBook.printAllNames();

        String output = outContent.toString().trim();
        assertEquals("", output);
    }
}
