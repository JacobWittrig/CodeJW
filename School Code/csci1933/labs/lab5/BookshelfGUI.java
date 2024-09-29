import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BookshelfGUI implements ActionListener {
    private Bookshelf shelf;
    private final Button remove;
    private final JFrame frame;
    private final Bookpanel bp;
    private final Label bookInfo;

    private Book selectedBook;

    public BookshelfGUI(Bookshelf shelf) {
        this.shelf = shelf;

        frame = new JFrame();
        frame.setSize(600, 300);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLayout(null);

        remove = new Button("Remove random book");
        remove.addActionListener(this);
        remove.setActionCommand("Remove");
        remove.setBounds(450, 50, 100, 50);

        bp = new Bookpanel(this);
        bp.setBounds(50, 100, 400, 50);

        bookInfo = new Label("Click remove random book to get a book!");
        bookInfo.setBounds(50, 10, 400, 30);

        frame.add(remove);
        frame.add(bp);
        frame.add(bookInfo);

        frame.setVisible(true);
        bp.repaint();
    }

    public static void main(String[] args) {
        Bookshelf b1 = new Bookshelf();
        
        b1.add(new Book("Eragon", "Christopher Paolini", 10.0));
        b1.add(new Book("Eldest", "Christopher Paolini", 10.0));
        b1.add(new Book("Brisingr", "Christopher Paolini", 10.0));
        b1.add(new Book("Inheritance", "Christopher Paolini", 10.0));
        b1.add(new Book("Dracula", "Bram Stoker", 7.5));
        //System.out.println(b1);
        BookshelfGUI b2 = new BookshelfGUI(b1);
        // TODO:
        //  - create a bookshelf object to pass in to the GUI constructor
        //  - create a new BookshelfGUI object which will display the GUI just by creating the object
    }

    public void repaint(Graphics g) {

        if (selectedBook == null) {
            g.setColor(Color.BLACK);
        } else {
            // TODO: change the color of the graphics context depending on the first letter of the authors name
            //  Be sure include at least 4 colors to cover the spread of the alphabet

            switch(selectedBook.getAuthor().charAt(0)) {
                case 'B':
                    g.setColor(Color.ORANGE);
                    break;
                case 'C':
                    g.setColor(Color.ORANGE);
                    break;
                case 'D':
                    g.setColor(Color.GREEN);
                    break;
                case 'E':
                    g.setColor(Color.ORANGE);
                    break;
                
                default:
                    g.setColor(Color.BLACK);
            }
        }
        // draws a filled in rectangle using the color selected in the switch statement
        g.fillRect(bookInfo.getX(), bookInfo.getY() + 75, bookInfo.getWidth(), bookInfo.getHeight());
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if (actionEvent.getActionCommand().equals("Remove")) {
            //System.out.println(shelf);
            Book removed = shelf.removeBook();
            System.out.println(removed);
            if (removed != null) {
                bookInfo.setText(removed.getTitle());
                selectedBook = removed;

                repaint(frame.getGraphics()); // repaints the book panel
            } else {
                // TODO: update the label to tell the user that there are no books in the shelf
                bookInfo.setText("No books to remove");
            }
        }
    }
}

class Bookpanel extends JPanel {
    BookshelfGUI shelfGUI;
    public Bookpanel(BookshelfGUI shelfGUI) {
        this.shelfGUI = shelfGUI;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        shelfGUI.repaint(g);
    }
}
