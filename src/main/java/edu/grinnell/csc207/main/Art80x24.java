package edu.grinnell.csc207.main;

import edu.grinnell.csc207.blocks.AsciiBlock;
import edu.grinnell.csc207.blocks.Grid;
import edu.grinnell.csc207.blocks.Line;
import edu.grinnell.csc207.blocks.Rect;

import java.io.PrintWriter;

/**
 * Create and print an amazing 80x24 ASCII artwork.
 *
 * @author Your Name Here
 * @author Your Name Here
 */
public class Art80x24 {
  /**
   * Create the artwork.
   *
   * @param args
   *   Command-line arguments (currently ignored).
   *
   * @exception Exception
   *   If something goes wrong with one of the underlying classes.
   */
  public static void main(String[] args) throws Exception {
    // PrintWriter pen = new PrintWriter(System.out, true);
    // AsciiBlock art = new Rect('^', 80, 24);
    // AsciiBlock.print(pen, art);
    // pen.close();



      AsciiBlock gridLine = new Grid(new Line("Hello"), 3, 4);
    try {
      System.out.println(gridLine.row(0));
    } catch (Exception e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  } // main(String[])
} // class Art80x24
