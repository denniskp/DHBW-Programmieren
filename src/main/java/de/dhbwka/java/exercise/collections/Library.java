package de.dhbwka.java.exercise.collections;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Objects;

record Book(String title, String author, int year, String publisher) { }

class BookTitleComparator implements Comparator<Book> {
    @Override
    public int compare(Book o1, Book o2) {
        return o1.title().compareTo(o2.title());
    }
}

class BookAuthorComparator implements Comparator<Book> {
    @Override
    public int compare(Book o1, Book o2) {
        return o1.author().compareTo(o2.author());
    }
}

class BookYearComparator implements Comparator<Book> {
    @Override
    public int compare(Book o1, Book o2) {
        if (o1.year() == o2.year()) return 0;
        return o1.year() < o2.year() ? -1 : 1;
    }
}

class BookPublisherComparator implements Comparator<Book> {
    @Override
    public int compare(Book o1, Book o2) {
        return o1.publisher().compareTo(o2.publisher());
    }
}

public class Library extends JFrame {
    private final JTextField txtTitle;
    private final JTextField txtAuthor;
    private final JTextField txtYear;
    private final JTextField txtPublisher;

    private final HashSet<Book> books = new HashSet<>();

    public Library() {
        this.setTitle("Library");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout(5, 5));

        JPanel pnlTop = new JPanel();
        pnlTop.setLayout(new GridLayout(4, 2, 2, 2));
        pnlTop.add(new JLabel("Title"));
        txtTitle = new JTextField();
        pnlTop.add(txtTitle);
        pnlTop.add(new JLabel("Author"));
        txtAuthor = new JTextField();
        pnlTop.add(txtAuthor);
        pnlTop.add(new JLabel("Year"));
        txtYear = new JTextField();
        pnlTop.add(txtYear);
        pnlTop.add(new JLabel("Publisher"));
        txtPublisher = new JTextField();
        pnlTop.add(txtPublisher);
        this.add(pnlTop, BorderLayout.NORTH);

        JPanel pnlMid = new JPanel();
        JButton btnSave = new JButton("Save Entry");
        btnSave.addActionListener(a -> {
            int year;
            try {
                year = Integer.parseInt(txtYear.getText());
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Please enter a valid year", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            Book newBook = new Book(txtTitle.getText(), txtAuthor.getText(), year, txtPublisher.getText());
            if (books.contains(newBook)) {
                JOptionPane.showMessageDialog(null, "This book can already be found in the Library", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            books.add(newBook);
            try (BufferedWriter writer = new BufferedWriter(new FileWriter("IOTest/library.txt", true))) {
                writer.write(String.format("%s;%s;%d;%s\n", newBook.title(), newBook.author(), newBook.year(), newBook.publisher()));
                JOptionPane.showMessageDialog(null, String.format("Saved '%s' to the library", txtTitle.getText()), "Success", JOptionPane.INFORMATION_MESSAGE);
                txtTitle.setText("");
                txtAuthor.setText("");
                txtYear.setText("");
                txtPublisher.setText("");
            } catch (IOException e) {
                JOptionPane.showMessageDialog(null, "Unable to save entry", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });
        pnlMid.add(btnSave);
        this.add(pnlMid, BorderLayout.CENTER);

        JPanel pnlBottom = new JPanel();
        pnlBottom.setLayout(new FlowLayout());
        pnlBottom.add(new JLabel("Output sorted by:"));
        JButton btnTitle = new JButton("Title");
        btnTitle.addActionListener(a -> sortedOutput(new BookTitleComparator(), "Title"));
        pnlBottom.add(btnTitle);
        JButton btnAuthor = new JButton("Author");
        btnAuthor.addActionListener(a -> sortedOutput(new BookAuthorComparator(), "Author"));
        pnlBottom.add(btnAuthor);
        JButton btnYear = new JButton("Year");
        btnYear.addActionListener(a -> sortedOutput(new BookYearComparator(), "Year"));
        pnlBottom.add(btnYear);
        JButton btnPublisher = new JButton("Publisher");
        btnPublisher.addActionListener(a -> sortedOutput(new BookPublisherComparator(), "Publisher"));
        pnlBottom.add(btnPublisher);
        this.add(pnlBottom, BorderLayout.SOUTH);

        this.pack();

        loadLibrary();
    }

    private void sortedOutput(Comparator<Book> comparator, String sortMethodName) {
        StringBuilder sb = new StringBuilder();
        books.stream().sorted(comparator).forEach(b -> {
            sb.append(String.format("%s;%s;%d;%s\n", b.title(), b.author(), b.year(), b.publisher()));
        });
        JOptionPane.showMessageDialog(null, sb.toString(), String.format("Books ordered by %s", sortMethodName), JOptionPane.INFORMATION_MESSAGE);
    }

    private void loadLibrary() {
        try (BufferedReader reader = new BufferedReader(new FileReader("IOTest/library.txt"))) {
            while (reader.ready()) {
                String[] bookInfo = reader.readLine().split(";");

                String title = bookInfo[0];
                String author = bookInfo[1];
                int year = Integer.parseInt(bookInfo[2]);
                String publisher = bookInfo[3];

                books.add(new Book(title, author, year, publisher));
            }
        } catch (FileNotFoundException ignored) {
        } catch (IOException e) {
            JOptionPane.showOptionDialog(null, "Unable to gather books", "Fatal error", JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE, null, new String[]{ "Exit" }, "Exit");
            System.exit(-1);
        }
    }

    public void showWindow() {
        this.setVisible(true);
    }

    public static void main(String[] args) {
        Library library = new Library();
        library.showWindow();
    }
}
