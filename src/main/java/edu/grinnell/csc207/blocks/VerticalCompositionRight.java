package edu.grinnell.csc207.blocks;

/**
 * The right-aligned vertical composition of two blocks.
 *
 * @author Mitch and Sheilla
 */
public class VerticalCompositionRight implements AsciiBlock {

  // +--------+------------------------------------------------------------
  // | Fields |
  // +--------+

  /**
   * The top block.
   */
  AsciiBlock above;

  /**
   * The below block.
   */
  AsciiBlock below;

  // +--------------+------------------------------------------------------
  // | Constructors |
  // +--------------+

  /**
   * Build a Horizontal Composition.
   *
   * @param aboveBlock The top block.
   *
   * @param belowBlock The bottom block.
   */
  public VerticalCompositionRight(AsciiBlock aboveBlock, AsciiBlock belowBlock) {
    this.above = aboveBlock;
    this.below = belowBlock;
  } // VerticalCompositionLeft

  // +---------+-----------------------------------------------------------
  // | Methods |
  // +---------+

  /**
   * Get one row from the block.
   *
   * @param i the number of the row
   *
   * @return row i.
   *
   * @exception Exception if i is outside the range of valid rows.
   */
  public String row(int i) throws Exception {
    if ((i < 0) || (i >= this.height())) {
      // Outside of normal bounds
      throw new Exception("Invalid row " + i);

    } else if (i < this.above.height()) {
      // In the top block
      return " ".repeat(this.width() - this.above.width()) + this.above.row(i);
    } else {
      // In the bottom block
      return " ".repeat(this.width() - this.below.width())
          + this.below.row(i - this.above.height());
    } // if/else
  } // row(int)

  /**
   * Determine how many rows are in the block.
   *
   * @return the number of rows
   */
  public int height() {
    return this.above.height() + this.below.height();
  } // height()

  /**
   * Determine how many columns are in the block.
   *
   * @return the number of columns
   */
  public int width() {
    return Math.max(this.above.width(), this.below.width());
  } // width()

  /**
   * Determine if this VerticalCompositionRight is structurally equivalent to another.
   *
   * @param other The block to compare to this block.
   *
   * @return true if the two blocks are structurally equivalent and false otherwise.
   */
  public boolean eqv(AsciiBlock other) {
    if (!(other instanceof VerticalCompositionLeft)) {
      return false;
    } // if statement
    VerticalCompositionRight otherCenter = (VerticalCompositionRight) other;
    return this.above.eqv(otherCenter.above) && this.above.eqv(otherCenter.above);
  } // boolean eqv
} // class VerticalCompositionLeft
