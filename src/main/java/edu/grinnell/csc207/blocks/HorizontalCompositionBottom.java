package edu.grinnell.csc207.blocks;


/**
 * The top-aligned horizontal copmosition of two blocks.
 *
 * @author Samuel A. Rebelsky
 * @author Mitch Paiva
 * @author Shiela Muligande
 *
 */
public class HorizontalCompositionBottom implements AsciiBlock {
  // +--------+------------------------------------------------------------
  // | Fields |
  // +--------+

  /**
   * The left block.
   */
  AsciiBlock left;

  /**
   * The right block.
   */
  AsciiBlock right;

  // +--------------+------------------------------------------------------
  // | Constructors |
  // +--------------+

  /**
   * Build a Horizontal Composition.
   *
   * @param leftBlock The block on the left.
   *
   * @param rightBlock The block on the right.
   */
  public HorizontalCompositionBottom(AsciiBlock leftBlock, AsciiBlock rightBlock) {
    this.left = leftBlock;
    this.right = rightBlock;
  } // HorizontalCompositionTop

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
    } else if ((i >= this.height() - this.left.height())
        && (i >= this.height() - this.right.height())) {
      // Inside both left and right bounds
      return this.left.row(i - (this.height() - this.left.height()))
          + this.right.row(i - (this.height() - this.right.height()));
    } else if (i >= this.height() - this.right.height()) {
      // Inside right bounds, outside left bounds
      return " ".repeat(this.left.width())
          + this.right.row(i - (this.height() - this.right.height()));
    } else if (i >= this.height() - this.left.height()) {
      int rightIndex = i - (this.height() - this.right.height());
      String rightRow;
      if (rightIndex >= 0) {
        rightRow = this.right.row(rightIndex);
      } else {
        rightRow = " ".repeat(this.right.width());
      } // else
      String leftRow = this.left.row(i - (this.height() - this.left.height()));
      return leftRow + rightRow;
    } else {
      return " ".repeat(this.width());
    } // else
  } // row(int)

  /**
   * Determine how many rows are in the block.
   *
   * @return the number of rows
   */
  public int height() {
    return Math.max(this.left.height(), this.right.height());
  } // height()

  /**
   * Determine how many columns are in the block.
   *
   * @return the number of columns
   */
  public int width() {
    return this.left.width() + this.right.width();
  } // width()


  /**
   * Determine if another block is structurally equivalent to this block.
   *
   * @param other The block to compare to this block.
   *
   * @return true if the two blocks are structurally equivalent and false otherwise.
   */
  public boolean eqv(AsciiBlock other) {
    if (!(other instanceof HorizontalCompositionBottom)) {
      return false;
    } // if statement
    HorizontalCompositionBottom otherCenter = (HorizontalCompositionBottom) other;
    return this.left.eqv(otherCenter.left) && this.right.eqv(otherCenter.right);
  } // eqv(AsciiBlock)

} // class HorizontalCompositionTop
