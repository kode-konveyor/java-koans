package java7;

import org.junit.jupiter.api.Test;

import java.io.*;

import static tools.Constants.__;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AboutTryWithResources {

    class AutoClosableResource implements AutoCloseable {
        public void foo() throws WorkException {
            throw new WorkException("Exception thrown while working");
        }

        public void close() throws CloseException {
            throw new CloseException("Exception thrown while closing");
        }
    }

    class WorkException extends Exception {
		private static final long serialVersionUID = 1L;

		public WorkException(String message) {
            super(message);
        }
    }

    class CloseException extends Exception {
		private static final long serialVersionUID = 1L;

		public CloseException(String message) {
            super(message);
        }
    }

    @Test
    public void lookMaNoClose() {
        String str = "first line"
                + System.lineSeparator()
                + "second line";
        InputStream is = new ByteArrayInputStream(str.getBytes());
        String line;
        /* BufferedReader implementing @see java.lang.AutoCloseable interface */
        try (BufferedReader br =
                     new BufferedReader(
                             new InputStreamReader(is))) {
            line = br.readLine();
            //br guaranteed to be closed
        } catch (IOException e) {
            line = "error";
        }
        assertEquals(line, __);
    }

    @Test
    public void lookMaNoCloseWithException() throws IOException {
        String line = "no need to close readers";
        try (BufferedReader br =
                     new BufferedReader(
                             new FileReader("I do not exist!"))) {
            line = br.readLine();
        } catch (FileNotFoundException e) {
            line = "no more leaking!";
        }
        assertEquals(line, __);
    }

    @Test
    public void lookMaNoCloseWithMultipleResources() throws IOException {
        String str = "first line"
                + System.lineSeparator()
                + "second line";
        InputStream is = new ByteArrayInputStream(str.getBytes());
        String line;
        //multiple resources in the same try declaration
        try (BufferedReader br =
                     new BufferedReader(
                             new FileReader("I do not exist!"));
             BufferedReader brFromString =
                     new BufferedReader(
                             new InputStreamReader(is))
        ) {
            line = br.readLine();
            line += brFromString.readLine();
        } catch (IOException e) {
            line = "error";
        }
        assertEquals(line, __);
    }

    @Test
    public void supressException() {
        String message = "";
        try {
            bar();
        } catch (WorkException e) {
            message += e.getMessage() + " " + e.getSuppressed()[0].getMessage();
        } catch (CloseException e) {
            message += e.getMessage();
        }
        assertEquals(message, __);
    }


    public void bar() throws CloseException, WorkException {
        try (AutoClosableResource autoClosableResource =
                     new AutoClosableResource()) {
            autoClosableResource.foo();
        }
    }
}