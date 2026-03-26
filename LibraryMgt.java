import java.awt.Color; 
import java.awt.Container; 
import java.awt.event.ActionEvent; 
import java.awt.event.ActionListener; 
import java.io.BufferedReader; 
import java.io.BufferedWriter; 
import java.io.FileReader; 
import java.io.FileWriter; 
import java.io.IOException; 
import java.util.*; 
import javax.swing.JButton; 
import javax.swing.JFrame; 
import javax.swing.JLabel; 
import javax.swing.JOptionPane; 
import javax.swing.JScrollPane; 
import javax.swing.JTextArea; 
import javax.swing.JTextField; 
 
public class LibraryMgt { 
    public static void main(String[] args) { 
        Library l1 = new Library(); 
        JFrame f1 = new JFrame(); 
        f1.setTitle("Central Library"); 
        f1.setBounds(100, 100, 500, 550); 
        f1.setVisible(true); 
        Container c1 = f1.getContentPane(); 
        f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
 
        JLabel greet = new JLabel(); 
        greet.setText("Welcome to the Central Library"); 
        f1.setLayout(null); 
        greet.setBounds(155, 5, 300, 100); 
        f1.add(greet); 
 
        JButton b1 = new JButton("Librarian Login"); 
        b1.setBounds(165, 90, 150, 60); 
        JButton b2 = new JButton("Enter as a Member"); 
        b2.setBounds(165, 200, 150, 60); 
        c1.add(b1); 
        c1.add(b2); 
 
        JButton b3 = new JButton("Add Member"); 
        JButton b4 = new JButton("Add Librarian"); 
        b3.setBounds(165, 300, 150, 60); 
        b4.setBounds(165, 400, 150, 60); 
 
        b3.addActionListener(new ActionListener() { 
            @Override 
            public void actionPerformed(ActionEvent e) { 
 
                String id = JOptionPane.showInputDialog("enter the member id"); 
                String name = JOptionPane.showInputDialog("enter the member name"); 
                String membership = JOptionPane.showInputDialog("enter the type of 
membership"); 
 
                Member member = new Member(id, name, membership); 
                l1.addMember(member); 
            } 
        }); 
        b4.addActionListener(new ActionListener() { 
            @Override 
            public void actionPerformed(ActionEvent e) { 
 
                String id = JOptionPane.showInputDialog("enter the member id"); 
                String name = JOptionPane.showInputDialog("enter the member name"); 
                String membership = JOptionPane.showInputDialog("enter the type of 
membership"); 
                String libid = JOptionPane.showInputDialog("enter the librarian id"); 
                String libdepart = JOptionPane.showInputDialog("enter the type of department"); 
 
                Librarian librarian = new Librarian(id, name, membership, libid, libdepart); 
                l1.addlibrarian(librarian); 
 
            } 
 
        }); 
 
        c1.add(b3); 
        c1.add(b4); 
        c1.setLayout(null); 
 
        b1.addActionListener(new ActionListener() { 
            @Override 
            public void actionPerformed(ActionEvent e) { 
 
                JFrame f2 = new JFrame("LIBRARIAN"); 
                f2.setBounds(100, 100, 500, 250); 
                f2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
                Container c2 = f2.getContentPane(); 
                JLabel label1 = new JLabel("Librarian ID"); 
                label1.setBounds(20, 20, 100, 110); 
                JTextField t1 = new JTextField("Enter the id"); 
                t1.setBounds(110, 55, 250, 30); 
                t1.setBackground(Color.white); 
                t1.setForeground(Color.orange); 
                f2.setVisible(true); 
                c2.setLayout(null); 
                c2.add(label1); 
                c2.add(t1); 
 
                JButton submit1 = new JButton("SUBMIT"); 
                submit1.setBounds(100, 100, 80, 50); 
                c2.add(submit1); 
                f1.setVisible(false); 
 
                submit1.addActionListener(new ActionListener() { 
                    @Override 
                    public void actionPerformed(ActionEvent e) { 
                        try { 
                            BufferedReader lr = new BufferedReader(new FileReader("librarain.txt")); 
                            String b; 
                            while ((b = lr.readLine()) != null) { 
                                if (b.contains(t1.getText())) { 
                                    f2.setVisible(false); 
                                    JFrame f3 = new JFrame("LIBRARIAN"); 
                                    f3.setBounds(100, 100, 960, 560); 
                                    f3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
                                    f3.setVisible(true); 
                                    Container c3 = f3.getContentPane(); 
 
                                    JButton addbookB = new JButton("ADD Book"); 
                                    addbookB.setBounds(20, 20, 110, 60); 
                                    c3.setLayout(null); 
                                    c3.add(addbookB); 
                                    addbookB.addActionListener(new ActionListener() { 
                                        @Override 
                                        public void actionPerformed(ActionEvent e) { 
                                            String id = JOptionPane.showInputDialog("enter book id"); 
                                            String title = JOptionPane.showInputDialog("enter the book title"); 
                                            String author = JOptionPane.showInputDialog("enter the book 
author"); 
                                            String publisher = JOptionPane.showInputDialog("enter the book 
publisher"); 
 
                                            Book book = new Book(id, title, author, publisher); 
                                            l1.addbook(book); 
                                            JOptionPane.showMessageDialog(null, "book is added"); 
 
                                        } 
                                    }); 
 
                                    JButton removeb = new JButton("Remove Book"); 
                                    removeb.setBounds(20, 80, 125, 60); 
                                    c3.add(removeb); 
                                    removeb.addActionListener(new ActionListener() { 
                                        @Override 
                                        public void actionPerformed(ActionEvent e) { 
                                            String n = (String) JOptionPane 
                                                    .showInputDialog("Enter the Name of the book to remove"); 
                                            l1.removebook(n); 
                                            JOptionPane.showMessageDialog(null, "book is removed"); 
 
                                        } 
                                    }); 
 
                                    JButton Displayb = new JButton("Display Books"); 
                                    Displayb.setBounds(20, 150, 130, 60); 
 
                                    JTextArea Dis = new JTextArea(); 
                                    Dis.setBounds(200, 35, 200, 300); 
                                    Dis.setEditable(false); 
                                    Dis.setLineWrap(true); 
                                    Dis.setWrapStyleWord(true); 
 
                                    JScrollPane s1 = new JScrollPane(Dis); 
                                    
s1.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS); 
                                    JButton remove1 = new JButton("remove"); 
                                    remove1.setBounds(200, 340, 80, 40); 
                                    remove1.addActionListener(new ActionListener() { 
                                        @Override 
                                        public void actionPerformed(ActionEvent e) { 
                                            Dis.setText(""); 
                                        } 
                                    }); 
 
                                    JLabel displaybook = new JLabel("BOOKS"); 
                                    displaybook.setBounds(200, 10, 50, 20); 
 
                                    c3.add(Dis); 
                                    c3.add(s1); 
                                    c3.add(displaybook); 
                                    c3.add(remove1); 
                                    c3.add(Displayb); 
 
                                    Displayb.addActionListener(new ActionListener() { 
                                        @Override 
                                        public void actionPerformed(ActionEvent e) { 
                                            l1.displayAllBooks(Dis); 
                                        } 
                                    }); 
 
                                    JButton allocate = new JButton("Allocate"); 
                                    allocate.setBounds(10, 220, 150, 70); 
 
                                    c3.add(allocate); 
                                    allocate.addActionListener(new ActionListener() { 
                                        @Override 
                                        public void actionPerformed(ActionEvent e) { 
                                            String bookId = JOptionPane.showInputDialog("enter the 
bookid"); 
                                            String memberId = JOptionPane.showInputDialog("enter the 
memberid"); 
                                            String issueDate = JOptionPane.showInputDialog("enter the issue 
date"); 
                                            String returnDate = JOptionPane.showInputDialog("enter the 
return date"); 
                                            Transaction trans = new Transaction(bookId, memberId, issueDate, 
                                                    returnDate); 
                                            l1.issueBook(trans); 
 
                                        } 
                                    }); 
 
                                    JButton returnB = new JButton("return Book"); 
                                    returnB.setBounds(10, 300, 150, 70); 
                                    c3.add(returnB); 
                                    returnB.addActionListener(new ActionListener() { 
                                        @Override 
                                        public void actionPerformed(ActionEvent e) { 
                                            String bookid = JOptionPane.showInputDialog("enter the 
bookid"); 
                                            String tid = JOptionPane.showInputDialog("enter the transaction 
id"); 
                                            l1.returnBook(bookid, tid); 
                                        } 
                                    }); 
 
                                    JButton removemem = new JButton("remove member"); 
                                    removemem.setBounds(10, 380, 150, 70); 
                                    c3.add(removemem); 
                                    removemem.addActionListener(new ActionListener() { 
                                        @Override 
                                        public void actionPerformed(ActionEvent e) { 
                                            String id = JOptionPane 
                                                    .showInputDialog("enter the id of the memeber you want to 
remove"); 
                                            l1.removemember(id); 
                                        } 
                                    }); 
 
                                    JTextField searchbt = new JTextField("Search for book"); 
                                    searchbt.setBounds(430, 5, 150, 25); 
                                    JButton searchb = new JButton("Search"); 
                                    searchb.setBounds(570, 5, 80, 25); 
                                    c3.add(searchbt); 
                                    c3.add(searchb); 
 
                                    JTextArea searchA = new JTextArea(); 
                                    searchA.setBounds(430, 36, 200, 300); 
                                    searchA.setEditable(false); 
                                    searchA.setLineWrap(true); 
                                    searchA.setWrapStyleWord(true); 
 
                                    JScrollPane s2 = new JScrollPane(searchA); 
                                    
s2.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS); 
 
                                    c3.add(searchA); 
 
                                    JButton remove2 = new JButton("remove"); 
                                    remove2.setBounds(430, 340, 80, 40); 
                                    c3.add(remove2); 
 
                                    searchb.addActionListener(new ActionListener() { 
                                        @Override 
                                        public void actionPerformed(ActionEvent e) { 
                                            String bname = searchbt.getText(); 
                                            l1.searchbook(bname, searchA); 
 
                                        } 
                                    }); 
 
                                    remove2.addActionListener(new ActionListener() { 
                                        @Override 
                                        public void actionPerformed(ActionEvent e) { 
                                            searchA.setText(""); 
                                        } 
                                    }); 
 
                                    JTextField searchmt = new JTextField("Search for Member"); 
                                    searchmt.setBounds(710, 5, 150, 25); 
                                    JButton searchm = new JButton("Search"); 
                                    searchm.setBounds(860, 5, 80, 25); 
 
                                    c3.add(searchmt); 
                                    c3.add(searchm); 
 
                                    JTextArea searchM = new JTextArea(); 
                                    searchM.setBounds(710, 36, 200, 300); 
                                    searchM.setEditable(false); 
                                    searchM.setLineWrap(true); 
                                    searchM.setWrapStyleWord(true); 
 
                                    JScrollPane s3 = new JScrollPane(searchM); 
                                    
s3.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS); 
                                    c3.add(searchM); 
 
                                    JButton remove3 = new JButton("remove"); 
                                    remove3.setBounds(710, 340, 80, 40); 
                                    c3.add(remove3); 
 
                                    searchm.addActionListener(new ActionListener() { 
                                        @Override 
                                        public void actionPerformed(ActionEvent e) { 
                                            String n = searchmt.getText(); 
                                            l1.searchmember(n, searchM); 
                                        } 
                                    }); 
 
                                    remove3.addActionListener(new ActionListener() { 
                                        @Override 
                                        public void actionPerformed(ActionEvent e) { 
                                            searchM.setText(""); 
                                        } 
                                    }); 
                                } 
                            } 
                        } catch (IOException a) { 
 
                        } 
                    } 
 
                }); 
 
            } 
        }); 
 
        // member 
 
        b2.addActionListener(new ActionListener() { 
            @Override 
            public void actionPerformed(ActionEvent e) { 
 
                JFrame f4 = new JFrame("MEMBER"); 
                f4.setBounds(100, 100, 400, 200); 
                f4.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
                JTextField memid = new JTextField("Enter member id"); 
                memid.setBounds(80, 20, 100, 40); 
 
                Container c4 = f4.getContentPane(); 
 
                c4.setLayout(null); 
 
                JLabel mId = new JLabel("Member ID"); 
                mId.setBounds(5, 20, 70, 40); 
 
                f1.setVisible(false); 
 
                c4.add(memid); 
                c4.add(mId); 
                f4.setVisible(true); 
 
                JButton submit2 = new JButton("Submit"); 
                submit2.setBounds(20, 70, 90, 40); 
                c4.add(submit2); 
 
                submit2.addActionListener(new ActionListener() { 
                    @Override 
                    public void actionPerformed(ActionEvent e) { 
                        String n = memid.getText(); 
 
                        try (BufferedReader b4 = new BufferedReader(new 
FileReader("members.txt"))) { 
 
                            String a; 
                            while ((a = b4.readLine()) != null) { 
                                String[] z = a.split(" "); 
 
                                if (z.length >= 3 && z[0].equals(n)) { 
 
                                    JFrame f5 = new JFrame("MEMBER"); 
                                    f5.setBounds(100, 100, 700, 400); 
                                    f5.setVisible(true); 
                                    f5.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
 
                                    f4.setVisible(false); 
 
                                    Container c5 = f5.getContentPane(); 
                                    c5.setLayout(null); 
                                    JLabel memName = new JLabel(z[1] + "......."); 
                                    memName.setBounds(280, 0, 100, 70); 
                                    c5.add(memName); 
 
                                    JLabel mybooks = new JLabel("My Books"); 
                                    mybooks.setBounds(20, 77, 100, 70); 
 
                                    JTextArea mybt = new JTextArea(); 
 
                                    mybt.setBounds(20, 120, 150, 150); 
                                    mybt.setEditable(false); 
                                    mybt.setLineWrap(true); 
                                    mybt.setWrapStyleWord(true); 
 
                                    JScrollPane s4 = new JScrollPane(mybt); 
                                    
s4.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS); 
                                    c5.add(s4); 
 
                                    JButton show = new JButton("show"); 
                                    show.setBounds(95, 95, 70, 23); 
 
                                    c5.add(mybooks); 
                                    c5.add(mybt); 
                                    c5.add(show); 
 
                                    show.addActionListener(new ActionListener() { 
                                        @Override 
                                        public void actionPerformed(ActionEvent e) { 
                                            String id = memid.getText(); 
                                            l1.showmybooks(id, mybt); 
                                        } 
                                    }); 
 
                                    JLabel disLabel = new JLabel("DisplayBooks"); 
                                    disLabel.setBounds(230, 78, 90, 60); 
                                    c5.add(disLabel); 
 
                                    JTextArea disT = new JTextArea(); 
 
                                    disT.setBounds(230, 120, 150, 150); 
                                    disT.setEditable(false); 
                                    disT.setLineWrap(true); 
                                    disT.setWrapStyleWord(true); 
 
                                    JScrollPane s5 = new JScrollPane(disT); 
                                    
s5.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS); 
                                    c5.add(s5); 
                                    c5.add(disT); 
 
                                    JButton disAllB = new JButton("Display"); 
                                    disAllB.setBounds(315, 94, 85, 25); 
                                    c5.add(disAllB); 
 
                                    disAllB.addActionListener(new ActionListener() { 
                                        @Override 
                                        public void actionPerformed(ActionEvent e) { 
                                            l1.displayAllBooks(disT); 
                                        } 
                                    }); 
 
                                    JButton remove7 = new JButton("Remove"); 
                                    remove7.setBounds(235, 275, 90, 30); 
                                    c5.add(remove7); 
 
                                    remove7.addActionListener(new ActionListener() { 
                                        @Override 
                                        public void actionPerformed(ActionEvent e) { 
                                            disT.setText(""); 
                                        } 
                                    }); 
 
                                    JTextField seBook = new JTextField("Search for book"); 
                                    seBook.setBounds(450, 85, 100, 25); 
                                    c5.add(seBook); 
 
                                    JButton search6 = new JButton("search"); 
                                    search6.setBounds(550, 84, 80, 25); 
                                    c5.add(search6); 
 
                                    JTextArea seT = new JTextArea(); 
 
                                    seT.setBounds(450, 110, 150, 150); 
                                    seT.setEditable(false); 
                                    seT.setLineWrap(true); 
                                    seT.setWrapStyleWord(true); 
 
                                    JScrollPane s6 = new JScrollPane(seT); 
                                    
s6.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS); 
                                    c5.add(s6); 
                                    c5.add(seT); 
 
                                    search6.addActionListener(new ActionListener() { 
                                        @Override 
                                        public void actionPerformed(ActionEvent e) { 
                                            String xx = seBook.getText(); 
                                            l1.searchbook(xx, seT); 
                                        } 
                                    }); 
 
                                    JButton remove8 = new JButton("Remove"); 
                                    remove8.setBounds(450, 265, 90, 30); 
                                    c5.add(remove8); 
                                    remove8.addActionListener(new ActionListener() { 
                                        @Override 
                                        public void actionPerformed(ActionEvent e) { 
                                            seT.setText(""); 
                                        } 
                                    }); 
 
                                } 
                            } 
 
                        } catch (IOException x) { 
                            System.out.println(x); 
                        } 
 
                    } 
 
                }); 
 
            } 
        }); 
    } 
} 
 
class Book { 
    private String id; 
    private String title; 
    private String author; 
    private String publisher; 
    private boolean isAvailable; 
 
    public Book(String id, String title, String author, String publisher) { 
        this.id = id; 
        this.title = title; 
        this.author = author; 
        this.publisher = publisher; 
        this.isAvailable = true; // By default, the book is available 
    } 
 
    // Getters and setters 
    public String getId() { 
        return id; 
    } 
 
    public String getTitle() { 
        return title; 
    } 
 
    public String getAuthor() { 
        return author; 
    } 
 
    public String getPublisher() { 
        return publisher; 
    } 
 
    public String isAvailable() { 
        if (isAvailable == true) { 
            return "yes.Available"; 
        } 
        return "no"; 
    } 
 
    // Book operations 
    public void issueBook() { 
        isAvailable = false; 
    } 
 
    public void returnBook() { 
        isAvailable = true; 
    } 
} 
 
class Member { 
    protected String id; 
    protected String name; 
    protected String membershipType; 
 
    public Member(String id, String name, String membershipType) { 
        this.id = id; 
        this.name = name; 
        this.membershipType = membershipType; 
    } 
 
    public String getId() { 
        return id; 
    } 
 
    public String getName() { 
        return name; 
    } 
 
    public String getMembershipType() { 
        return membershipType; 
    } 
 
    public void viewBooks(java.util.List<Book> books) { 
        System.out.println("Books available:"); 
        for (Book book : books) { 
            System.out.println(book.getTitle() + " by " + book.getAuthor()); 
        } 
    } 
} 
 
class Librarian extends Member { 
    protected String librarianId; 
    protected String department; 
 
    public Librarian(String id, String name, String membershipType, String librarianId, String 
department) { 
        super(id, name, membershipType); 
        this.librarianId = librarianId; 
        this.department = department; 
    } 
 
    public void addBook(java.util.ArrayList<Book> books, Book book) { 
        books.add(book); 
        System.out.println("Book added successfully!"); 
    } 
 
    public void removeBook(java.util.ArrayList<Book> books, String bookId) { 
        for (Book book : books) { 
            if (book.getId().equals(bookId)) { 
                books.remove(book); 
            } 
        } 
        System.out.println("Book removed!"); 
    } 
} 
 
class Transaction { 
 
    int transactionId = 0; 
    String bookId; 
    String memberId; 
    String issueDate, returnDate; 
 
    Transaction(String b, String m, String i, String r) { 
        this.bookId = b; 
        this.memberId = m; 
        this.issueDate = i; 
        this.returnDate = r; 
    } 
 
    public int autoincrease() { 
        int inc = 0; 
        try (BufferedReader b1 = new BufferedReader(new FileReader("transaction.txt"))) { 
            String a; 
            while ((a = b1.readLine()) != null) { 
                String[] parts = a.split(" "); 
 
                if (parts.length > 0) { 
                    try { 
                        inc = Integer.parseInt(parts[0]); 
                    } catch (NumberFormatException e) { 
                        System.out.println("Skipping invalid number: " + parts[0]); 
                    } 
                } 
            } 
        } catch (IOException e) { 
            System.out.println("Error reading the file: " + e.getMessage()); 
        } 
 
        return inc + 1; 
    } 
 
} 
 
class Library { 
 
    List<Book> books = new ArrayList<>(); 
    List<Member> members = new ArrayList<>(); 
    ArrayList<Librarian> librarians = new ArrayList<>(); 
    ArrayList<Transaction> transactions = new ArrayList<>(); 
 
    // Accessors 
    public List<Book> getBooks() { 
        return books; 
    } 
 
    public String getMembers() { 
        return members.get(0).id + "  " + members.get(0).name + "  " + 
members.get(0).membershipType; 
    } 
 
    public void addMember(Member member) { 
        members.add(member); 
        String c = (String) (members.get(members.size() - 1).getId() + " " + 
members.get(members.size() - 1).getName() 
                + " " + members.get(members.size() - 1).getMembershipType()); 
        try (BufferedWriter b1 = new BufferedWriter(new FileWriter("members.txt", true))) { 
            b1.write(c); 
            b1.newLine(); 
            System.out.println("ok"); 
        } catch (IOException e) { 
            System.out.println("not added"); 
        } 
 
    } 
 
    public void addlibrarian(Librarian librarian) { 
        librarians.add(librarian); 
        String c = (String) (librarians.get(librarians.size() - 1).getId() + " " 
                + librarians.get(librarians.size() - 1).getName() + " " 
                + librarians.get(librarians.size() - 1).getMembershipType()); 
        String d = (String) (librarians.get(librarians.size() - 1).librarianId + " " 
                + librarians.get(librarians.size() - 1).department); 
        try (BufferedWriter b1 = new BufferedWriter(new FileWriter("librarain.txt", true))) { 
            b1.write(d); 
            b1.newLine(); 
        } catch (IOException e) { 
            System.out.println("not added"); 
        } 
 
        try (BufferedWriter b2 = new BufferedWriter(new FileWriter("members.txt", true))) { 
            b2.write(c); 
            b2.newLine(); 
            System.out.println("printed member"); 
        } catch (IOException e) { 
            System.out.println("not added"); 
        } 
 
    } 
 
    public void issueBook(Transaction t) { 
        transactions.add(t); 
 
        ArrayList<String> bookid = new ArrayList<>(); 
        ArrayList<String> memids = new ArrayList<>(); 
 
        try (BufferedReader b1 = new BufferedReader(new FileReader("books.txt"))) { 
            String a; 
 
            while ((a = b1.readLine()) != null) { 
                String b[] = new String[15]; 
                b = a.split(""); 
                for (int i = 0; i < b.length; i++) { 
                    if (i == 0) { 
                        bookid.add(b[i]); 
                    } 
                } 
            } 
        } catch (IOException e) { 
        } 
 
        try (BufferedReader b2 = new BufferedReader(new FileReader("members.txt"))) { 
            String a; 
 
            while ((a = b2.readLine()) != null) { 
                String b[] = new String[15]; 
                b = a.split(""); 
                for (int i = 0; i < b.length; i++) { 
                    if (i == 0) { 
                        memids.add(b[i]); 
                    } 
                } 
            } 
        } catch (IOException e) { 
        } 
 
        try (BufferedWriter b3 = new BufferedWriter(new FileWriter("transaction.txt", true))) { 
 
        } catch (IOException e) { 
        } 
 
        if (bookid.contains(transactions.get(transactions.size() - 1).bookId) 
                && memids.contains(transactions.get(transactions.size() - 1).memberId)) { 
            try (BufferedReader b4 = new BufferedReader(new FileReader("books.txt")); 
                 BufferedReader b5 = new BufferedReader(new FileReader("members.txt")); 
                 BufferedWriter b6 = new BufferedWriter(new FileWriter("transaction.txt", true))) { 
                String a; 
                while ((a = b4.readLine()) != null) { 
                    String[] z = a.split(" "); 
 
                    if (z.length >= 5 && z[0].equals(transactions.get(transactions.size() - 1).bookId) 
                            && z[4].equals("yes.Available")) { 
 
                        b6.write(Integer.toString(transactions.get(transactions.size() - 1).autoincrease()) 
+ " " + 
                                transactions.get(transactions.size() - 1).bookId + " " + 
                                transactions.get(transactions.size() - 1).memberId + " " + 
                                transactions.get(transactions.size() - 1).issueDate + " " + 
                                transactions.get(transactions.size() - 1).returnDate); 
                        b6.newLine(); 
                    } 
                } 
            } catch (IOException e) { 
                System.out.println("No transaction: " + e.getMessage()); 
            } 
 
            List<String> modifiedLines = new ArrayList<>(); 
 
            try (BufferedReader b1 = new BufferedReader(new 
FileReader("D://project//books.txt"))) { 
                String a; 
 
                while ((a = b1.readLine()) != null) { 
                    if (a.contains(transactions.get(transactions.size() - 1).bookId)) { 
                        String b = a; 
 
                        a = a.replace("yes.Available", "Allocated"); 
                    } 
 
                    modifiedLines.add(a); 
                } 
            } catch (IOException e) { 
                System.out.println("Error reading file: " + e.getMessage()); 
            } 
 
            try (BufferedWriter b2 = new BufferedWriter(new FileWriter("D://project//books.txt", 
false))) { 
                for (String line : modifiedLines) { 
                    b2.write(line); 
                    b2.newLine(); 
 
                } 
                for (int i = 0; i < modifiedLines.size(); i++) { 
                    modifiedLines.remove(i); 
                } 
 
            } catch (IOException e) { 
                System.out.println("Error writing to file: " + e.getMessage()); 
            } 
 
        } 
 
    } 
 
    public void returnBook(String bookId, String tid) { 
 
        List<String> modifiedLines = new ArrayList<>(); 
 
        try (BufferedReader b1 = new BufferedReader(new 
FileReader("D://project//books.txt"))) { 
            String a; 
 
            while ((a = b1.readLine()) != null) { 
                String[] z = a.split(" "); 
 
                if (z.length >= 5 && z[0].equals(bookId)) { 
 
                    a = a.replace("Allocated", "yes.Available"); 
 
                } 
                modifiedLines.add(a); 
            } 
        } catch (IOException e) { 
            System.out.println("Error reading file: " + e.getMessage()); 
        } 
 
        try (BufferedWriter b2 = new BufferedWriter(new FileWriter("D://project//books.txt", 
false))) { 
            for (String line : modifiedLines) { 
                b2.write(line); 
                b2.newLine(); 
 
            } 
            for (int i = 0; i < modifiedLines.size(); i++) { 
                modifiedLines.remove(i); 
            } 
 
        } catch (IOException e) { 
            System.out.println("Error writing to file: " + e.getMessage()); 
        } 
 
        List<String> modifiedLines1 = new ArrayList<>(); 
 
        try (BufferedReader b1 = new BufferedReader(new FileReader("transaction.txt"))) { 
            String a; 
 
            while ((a = b1.readLine()) != null) { 
                String[] z = a.split(" "); 
 
                if (z.length >= 5 && !z[0].equals(tid)) { 
                    modifiedLines1.add(a); 
 
                } 
            } 
        } catch (IOException e) { 
            System.out.println("Error reading file: " + e.getMessage()); 
        } 
 
        try (BufferedWriter b2 = new BufferedWriter(new FileWriter("transaction.txt", false))) { 
            for (String line : modifiedLines1) { 
                b2.write(line); 
                b2.newLine(); 
 
            } 
            for (int i = 0; i < modifiedLines1.size(); i++) { 
                modifiedLines1.remove(i); 
            } 
 
        } catch (IOException e) { 
            System.out.println("Error writing to file: " + e.getMessage()); 
        } 
 
    } 
 
    public void addbook(Book book) { 
        books.add(book); 
 
        String c = (String) (books.get(books.size() - 1).getId() + " " + books.get(books.size() - 
1).getTitle() + " " 
                + books.get(books.size() - 1).getAuthor() + " " + books.get(books.size() - 
1).getPublisher() + " " 
                + books.get(books.size() - 1).isAvailable()); 
        try (BufferedWriter b2 = new BufferedWriter(new FileWriter("books.txt", true))) { 
            b2.write(c); 
            b2.newLine(); 
        } catch (IOException e) { 
            System.out.println("not write "); 
        } 
 
    } 
 
    public void displayAllBooks(JTextArea t) { 
        try (BufferedReader b1 = new BufferedReader(new FileReader("books.txt"))) { 
            String a; 
 
            String c = ""; 
            while ((a = b1.readLine()) != null) { 
                String d = a; 
 
                String b[] = new String[30]; 
                b = d.split(" "); 
                for (int i = 0; i < b.length - 1; i++) { 
                    if (i == 1) { 
                        c = b[i]; 
                    } 
 
                } 
                t.append(c); 
                t.append("\n"); 
 
                System.out.println("ok"); 
            } 
        } catch (IOException e) { 
            e.printStackTrace(); 
        } 
    } 
 
    public void removebook(String n) { 
        List<String> modifiedLines = new ArrayList<>(); 
 
        try (BufferedReader b1 = new BufferedReader(new 
FileReader("D://project//books.txt"))) { 
            String a; 
 
            while ((a = b1.readLine()) != null) { 
                if (!a.contains(n)) { 
                    String b = a; 
 
                    modifiedLines.add(a); 
                } 
 
            } 
        } catch (IOException e) { 
            System.out.println("Error reading file: " + e.getMessage()); 
        } 
 
        try (BufferedWriter b2 = new BufferedWriter(new FileWriter("D://project//books.txt", 
false))) { 
            for (String line : modifiedLines) { 
                b2.write(line); 
                b2.newLine(); 
 
            } 
            for (int i = 0; i < modifiedLines.size(); i++) { 
                modifiedLines.remove(i); 
            } 
 
        } catch (IOException e) { 
            System.out.println("Error writing to file: " + e.getMessage()); 
        } 
    } 
 
    public void removemember(String id) { 
 
        List<String> modifiedLines = new ArrayList<>(); 
 
        try (BufferedReader b1 = new BufferedReader(new FileReader("members.txt"))) { 
            String a; 
 
            while ((a = b1.readLine()) != null) { 
                String b = a; 
                if (a.contains(id)) { 
                    if (!a.contains("librarian")) { 
                        a = null; 
                        JOptionPane.showMessageDialog(null, "removed"); 
                    } else { 
                        modifiedLines.add(a); 
                        JOptionPane.showMessageDialog(null, "librarian can't be removed"); 
                    } 
 
                } else { 
                    modifiedLines.add(a); 
                } 
 
            } 
        } catch (IOException e) { 
            System.out.println("Error reading file: " + e.getMessage()); 
        } 
 
        try (BufferedWriter b2 = new BufferedWriter(new FileWriter("members.txt", false))) { 
            for (String line : modifiedLines) { 
                b2.write(line); 
                b2.newLine(); 
 
            } 
            for (int i = 0; i < modifiedLines.size(); i++) { 
                modifiedLines.remove(i); 
            } 
 
        } catch (IOException e) { 
            System.out.println("Error writing to file: " + e.getMessage()); 
        } 
 
    } 
 
    public void searchbook(String Bname, JTextArea t) { 
 
        try (BufferedReader b4 = new BufferedReader(new FileReader("books.txt"))) { 
 
            String a; 
            while ((a = b4.readLine()) != null) { 
                String[] z = a.split(" "); 
 
                if (z.length >= 5 && z[1].equals(Bname)) { 
 
                    t.append(z[1] + " " + z[4]); 
                    t.append("\n"); 
 
                } 
            } 
 
        } catch (IOException e) { 
        } 
 
    } 
 
    public void searchmember(String Mname, JTextArea t) { 
 
        try (BufferedReader b4 = new BufferedReader(new FileReader("members.txt"))) { 
 
            String a; 
            while ((a = b4.readLine()) != null) { 
                String[] z = a.split(" "); 
 
                if (z.length >= 3 && z[1].equals(Mname)) { 
 
                    t.append(z[1] + " " + z[2]); 
                    t.append("\n"); 
 
                } 
            } 
 
        } catch (IOException e) { 
        } 
 
    } 
 
    public void showmybooks(String id, JTextArea t) { 
        String bid = ""; 
        try (BufferedReader b4 = new BufferedReader(new FileReader("transaction.txt"))) { 
            String a; 
            while ((a = b4.readLine()) != null) { 
                String[] z = a.split(" "); 
 
                if (z.length >= 5 && z[2].equals(id)) { 
                    bid = z[1]; 
                    System.out.println("ok"); 
 
                } 
            } 
 
        } catch (IOException e) { 
        } 
        try (BufferedReader r1 = new BufferedReader(new FileReader("books.txt"))) { 
            String a; 
            while ((a = r1.readLine()) != null) { 
                String[] z = a.split(" "); 
                if (z.length >= 4 && z[0].equals(bid)) { 
                    t.append(z[1]); 
                    t.append("\n"); 
                    System.out.println("ok"); 
 
                } 
            } 
        } catch (IOException e) { 
        } 
    } 
} 
 
 