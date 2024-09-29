package edu.grinnell.csc207.main;

import edu.grinnell.csc207.blocks.AsciiBlock;
import edu.grinnell.csc207.blocks.HComp;
import edu.grinnell.csc207.blocks.VComp;
import edu.grinnell.csc207.blocks.Rect;
import edu.grinnell.csc207.blocks.VAlignment;
import edu.grinnell.csc207.blocks.HAlignment;


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
   * @param args Command-line arguments (currently ignored).
   *
   * @exception Exception If something goes wrong with one of the underlying classes.
   */
  public static void main(String[] args) throws Exception {
    // PrintWriter pen = new PrintWriter(System.out, true);
    // AsciiBlock art = new Rect('^', 80, 24);
    // AsciiBlock.print(pen, art);
    // pen.close();

    int blockWidth = 10;
    int blockHeight = 4;

    AsciiBlock blockH = new Rect('H', blockWidth, blockHeight);
    AsciiBlock blockE = new Rect('E', blockWidth, blockHeight);
    AsciiBlock blockL = new Rect('L', blockWidth, blockHeight);
    AsciiBlock blockP = new Rect('P', blockWidth, blockHeight);
    AsciiBlock blockM = new Rect('M', blockWidth, blockHeight);

    AsciiBlock[] helpBlocks = {blockH, blockE, blockL, blockP};

    AsciiBlock[] meheBlocks = {blockM, blockE, blockH, blockE};

    AsciiBlock line1Segment = new HComp(VAlignment.TOP, helpBlocks);

    AsciiBlock[] line1Blocks = {line1Segment, line1Segment};
    AsciiBlock line1 = new HComp(VAlignment.TOP, line1Blocks);

    AsciiBlock line2Segment = new HComp(VAlignment.TOP, meheBlocks);

    AsciiBlock[] line2Blocks = {line2Segment, line2Segment};
    AsciiBlock line2 = new HComp(VAlignment.TOP, line2Blocks);

    AsciiBlock[] alternatingWord = {line1, line2, line1, line2, line1, line2};
    AsciiBlock finalArt = new VComp(HAlignment.LEFT, alternatingWord);


    PrintWriter pen = new PrintWriter(System.out, true);
    AsciiBlock.print(pen, finalArt);
  } // main(String[])
} // class Art80x24
