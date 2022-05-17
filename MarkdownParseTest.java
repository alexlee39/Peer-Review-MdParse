import static org.junit.Assert.*;
import org.junit.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
public class MarkdownParseTest {
    @Test
    public void addition() {
        assertEquals(2, 1 + 1);
    }

    @Test
    public void test1() throws IOException {
        Path fileName = Path.of("test-file.md");
        String content = Files.readString(fileName);
        ArrayList<String> links = MarkdownParse.getLinks(content);
        assertEquals(List.of("https://something.com", "some-thing.html"), links);
    }

    @Test
    public void test2() throws IOException {
        Path fileName = Path.of("test-file2.md");
        String content = Files.readString(fileName);
        ArrayList<String> links = MarkdownParse.getLinks(content);
        assertEquals(List.of(), links);
    }

    @Test
    public void test3() throws IOException {
        Path fileName = Path.of("test-file3.md");
        String content = Files.readString(fileName);
        ArrayList<String> links = MarkdownParse.getLinks(content);
        assertEquals(List.of("https://something.com", "some-thing.html"), links);
    }

    @Test
    public void test4() throws IOException {
        Path fileName = Path.of("test-file4.md");
        String content = Files.readString(fileName);
        ArrayList<String> links = MarkdownParse.getLinks(content);
        assertEquals(List.of(), links);
    }

    @Test
    public void failTest() {
        assertEquals(2, 1+1);
    }

    @Test
    public void testSnip1(){
        // Path fileName = Path.of("Snippet1.md");
        // String content = Files.readString(fileName);
        // ArrayList<String> links = MarkdownParse.getLinks(content);
        // assertEquals(List.of("`google.com","google.com","ucsd.edu"), links);
        try{
            assertEquals(List.of("`google.com","google.com","ucsd.edu"),
            MarkdownParse.getLinks(Files.readString(Path.of("Snippet1.md"))));
            } catch (IOException e){
                fail();
            }
    }

    @Test
    public void testSnip2(){
        try{
            assertEquals(List.of("a.com","a.com(())","example.com"),
            MarkdownParse.getLinks(Files.readString(Path.of("Snippet2.md"))));
            } catch (IOException e){
                fail();
            }
    }

    @Test 
    public void testSnip3(){
        try{
            assertEquals(List.of("https://www.twitter.com",
                "https://sites.google.com/eng.ucsd.edu/cse-15l-spring-202s2/schedule",
            "https://cse.ucsd.edu/"),MarkdownParse.getLinks(Files.readString(Path.of("Snippet3.md"))));
            } catch (IOException e){
                fail();
            }
    }
}