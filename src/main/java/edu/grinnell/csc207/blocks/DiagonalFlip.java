package edu.grinnell.csc207.blocks;

/**
 * A horizontally flipped ASCII block.
 *
 * @author Samuel A. Rebelsky
 * @author Mitch Paiva
 * @author Shiela Muligande
 *
 */
public class DiagonalFlip implements AsciiBlock {
  // +--------+------------------------------------------------------------
  // | Fields |
  // +--------+

  /**
   * The origin block.
   *
   * @author Mitch Paiva
   *
   * @author Shiela Muligande
   */
  AsciiBlock block;

  /**
   * A diagonal line.
   */
  AsciiBlock diagonalBlock;

  // +--------------+------------------------------------------------------
  // | Constructors |
  // +--------------+

  /**
   * Build a new block with the specified contents.
   *
   * @param original The original block.
   */
  public DiagonalFlip(AsciiBlock original) {
    this.block = original;
    this.diagonalBlock = reduce();
  } // HFlip(AsciiBlock)

  // +---------+-----------------------------------------------------------
  // | Methods |
  // +---------+

  /**
   * Get one row from the block.
   *
   *
   * @return row i.
   *
   * @exception Exception If the row is invalid.
   */
  public AsciiBlock reduce() {
    return new VFlip(new HFlip(this.block));
  } // row(int)


  /**
   * Get one row from the block.
   *
   * @param i the number of the row
   *
   * @return row i.
   *
   * @exception Exception If the row is invalid.
   */
  public String row(int i) throws Exception {
    return this.diagonalBlock.row(i);
  } // row(int)

  /**
   * Determine how many rows are in the block.
   *
   * @return the number of rows
   */
  public int height() {
    return this.block.height();
  } // height()

  /**
   * Determine how many columns are in the block.
   *
   * @return the number of columns
   */
  public int width() {
    return this.block.width();
  } // width()

  /**
   * Determine if another block is structurally equivalent to this block.
   *
   * @param other The block to compare to this block.
   *
   * @return true if the two blocks are structurally equivalent and false otherwise.
   */
  public boolean eqv(AsciiBlock other) {
    return ((other instanceof HFlip) && (this.eqv((HFlip) other)));
  } // eqv(AsciiBlock)


  /**
   * Determine if this HFlip is structurally equivalent to another.
   *
   * @param other The block to compare to this block.
   *
   * @return true if the two blocks are structurally equivalent and false otherwise.
   */

  public boolean eqv(DiagonalFlip other) {
    return (this.width() == other.width()) && (this.height() == other.height())
        && (this.block.eqv(other));
  } // eqv(HComp)
} // class HFlip
