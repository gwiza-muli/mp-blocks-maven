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
 * Tests of the new block.
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
    assertEquals(0, empty.width(),
        "Passed");
    assertEquals(0, empty.height(),
        "Passed");
  } // testHFlipEmpty()

    /**
   * DiagonalFlip of the empty block.
   */
  @Test
  public void testDiagonalLine() {
    AsciiBlock Test = new Line("Sheilla");

    AsciiBlock Diagonalled = new DiagonalFlip(Test);
    assertEquals(7, Diagonalled.width(),
        "M: Correct width for hflipped hello");
    assertEquals(1, Diagonalled.height(),
        "M: Correct height for hflipped hello");
    assertEquals("alliehS\n", TestUtils.toString(Diagonalled),
        "M: Correct contents for hflipped hello");

  }
}
