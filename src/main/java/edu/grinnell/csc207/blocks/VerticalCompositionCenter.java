package edu.grinnell.csc207.blocks;

/**
 * The center-aligned vertical composition of two blocks.
 *
 * @author Mitch Paiva
 * @author Shiella Muligande
 */
public class VerticalCompositionCenter implements AsciiBlock {
  // +--------+------------------------------------------------------------
  // | Fields |
  // +--------+

  /**
   * The left block.
   */
  AsciiBlock above;

  /**
   * The right block.
   */
  AsciiBlock below;

  // +--------------+------------------------------------------------------
  // | Constructors |
  // +--------------+

  /**
   * Build a Horizontal Composition.
   *
   * @param aboveBlock The block on the left.
   *
   * @param belowBlock The block on the right.
   */
  public VerticalCompositionCenter(AsciiBlock aboveBlock, AsciiBlock belowBlock) {
    this.above = aboveBlock;
    this.below = belowBlock;
  } // VerticalCompositionCenter


  // +---------+-----------------------------------------------------------
  // | Methods |
  // +---------+

  /**
   * Get one row from the block.
   *
   * @param i the number of the row
   *
   * @return row i./**
 * The left-aligned vertical composition of two blocks.
 *
 * @author Mitch and Sheilla
 */

  public String row(int i) throws Exception {
    if ((i < 0) || (i >= this.height())) {
      // Outside of normal bounds
      throw new Exception("Invalid row " + i);
    } else if (i < this.above.height()) {
      String aboveRow = this.above.row(i);
      int offset = this.width() - this.above.width();
      int leftSpace = offset / 2;
      int rightSpace = offset - leftSpace;
      return " ".repeat(leftSpace) + aboveRow + " ".repeat(rightSpace);
    } else {
      int belowIndex = i - this.above.height();
      String belowRow = this.below.row(belowIndex);
      int offset = this.width() - this.below.width();
      int leftSpace = offset / 2;
      int rightSpace = offset - leftSpace;
      return " ".repeat(leftSpace) + belowRow + " ".repeat(rightSpace);
    } // else statement
  } //row(int i)

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
   * Determine if this VerticalCompositionCenter is structurally equivalent to another.
   *
   * @param other The block to compare to this block.
   *
   * @return true if the two blocks are structurally equivalent and false otherwise.
   */
  public boolean eqv(AsciiBlock other) {
    if (!(other instanceof HorizontalCompositionCenter)) {
      return false;
    } // if statement
    VerticalCompositionCenter otherCenter = (VerticalCompositionCenter) other;
    return this.above.eqv(otherCenter.above) && this.below.eqv(otherCenter.below);
  } // eqv(AsciiBlock)
} // VerticalCompositionCenter
