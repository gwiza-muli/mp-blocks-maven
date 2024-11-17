package edu.grinnell.csc207;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import edu.grinnell.csc207.blocks.AsciiBlock;
import edu.grinnell.csc207.blocks.DiagonalFlip;
import edu.grinnell.csc207.blocks.Empty;
import edu.grinnell.csc207.blocks.HAlignment;
import edu.grinnell.csc207.blocks.HComp;
import edu.grinnell.csc207.blocks.HFlip;
import edu.grinnell.csc207.blocks.Line;
import edu.grinnell.csc207.blocks.VAlignment;
import edu.grinnell.csc207.blocks.VComp;
import edu.grinnell.csc207.blocks.VFlip;

/**
 * Tests of the new block. Specifically Diagonal.
 *
 * @author Sam Rebelsky
 * @author Mitch Paiva
 * @author Shiella Muligande
 */
public class TestNewBlock {
  // +-------+-------------------------------------------------------
  // | Tests |
  // +-------+

  /**
   * DiagonalFlip of the empty block.
   */
  @Test
  public void testDiagonalFlipEmpty() {
    AsciiBlock empty = new DiagonalFlip(new Empty());
    assertEquals(0, empty.width(), "Passed");
    assertEquals(0, empty.height(), "Passed");
  } // testHFlipEmpty()

  /**
   * DiagonalFlip of the empty block.
   */
  @Test
  public void testDiagonalLine() {
    AsciiBlock Test = new Line("Sheilla");

    AsciiBlock Diagonalled = new DiagonalFlip(Test);
    assertEquals(7, Diagonalled.width(), "Correct width for Sheilla");
    assertEquals(1, Diagonalled.height(), "correct height for Sheilla");
    assertEquals("alliehS\n", TestUtils.toString(Diagonalled),
        "M: Correct contents for hflipped hello");

  }

  /**
   * DiagonalFlip of a paragraph
   */
  @Test
  public void testDiagonalParagraph() {
    AsciiBlock line1 = new Line("Hi Everyone");
    AsciiBlock line2 = new Line("this is a test.");
    AsciiBlock line3 = new Line("how are you?");

    AsciiBlock paragraph = new VComp(HAlignment.RIGHT, new AsciiBlock[] {line1, line2, line3});


    AsciiBlock diagonalParagraph = new DiagonalFlip(paragraph);
    assertEquals(15, diagonalParagraph.width(), "Correct width for a paragraph");
    assertEquals(3, diagonalParagraph.height(), "correct height for a paragraph");
    assertEquals("?uoy era woh   \n" + ".tset a si siht\n" + "enoyrevE iH    \n",
        TestUtils.toString(diagonalParagraph), "correct contents for a flipped paragraph.");

  }

  /**
   * DiagonalFlip of the two lines.
   */
  @Test
  public void testTwoLineSwitched() {
    AsciiBlock line1 = new Line("Grinnell");
    AsciiBlock line2 = new Line("College");

    AsciiBlock paragraph = new VComp(HAlignment.RIGHT, new AsciiBlock[] {line1, line2});


    AsciiBlock diagonalParagraph = new DiagonalFlip(paragraph);
    assertEquals(8, diagonalParagraph.width(), "Correct width for a paragraph");
    assertEquals(2, diagonalParagraph.height(), "correct height for a paragraph");
    assertEquals("egelloC \n" + "llennirG\n", TestUtils.toString(diagonalParagraph),
        "correct contents for a flipped two lines..");

  }

  /**
   * DiagonalFlip of two lines that are the same.
   */
  @Test
  public void testTwoLineSame() {
    AsciiBlock line1 = new Line("Same");
    AsciiBlock line2 = new Line("Same");

    AsciiBlock paragraph = new VComp(HAlignment.RIGHT, new AsciiBlock[] {line1, line2});

    AsciiBlock diagonalParagraph = new DiagonalFlip(paragraph);
    assertEquals(4, diagonalParagraph.width(), "Correct width for a paragraph");
    assertEquals(2, diagonalParagraph.height(), "correct height for a paragraph");
    assertEquals("emaS\n" + "emaS\n", TestUtils.toString(diagonalParagraph),
        "correct contents for a flipped two lines..");

  }

  /**
   * DiagonalFlip of two lines that are the same.
   */
  @Test
  public void testTwoLineSameOneLineNot() {
    AsciiBlock line1 = new Line("Same");
    AsciiBlock line2 = new Line("SameNOT");

    AsciiBlock paragraph = new VComp(HAlignment.RIGHT, new AsciiBlock[] {line1, line2});

    AsciiBlock diagonalParagraph = new DiagonalFlip(paragraph);
    assertEquals(7, diagonalParagraph.width(), "Correct width for a paragraph");
    assertEquals(2, diagonalParagraph.height(), "correct height for a paragraph");
    assertEquals("TONemaS\n" + "emaS   \n", TestUtils.toString(diagonalParagraph),
        "correct contents for a flipped two lines..");

  }
}


