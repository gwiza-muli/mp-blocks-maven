package edu.grinnell.csc207.blocks;

import java.util.Arrays;

/**
 * The horizontal composition of blocks.
 *
 * @author Samuel A. Rebelsky
 * @author Your Name Here
 */
public class HComp implements AsciiBlock {
  // +--------+------------------------------------------------------------
  // | Fields |
  // +--------+

  /**
   * The blocks.
   */
  AsciiBlock[] blocks;

  /**
   * How the blocks are aligned.
   */
  VAlignment align;

  /** the resulting H composition. */
  AsciiBlock result;
  // +--------------+------------------------------------------------------
  // | Constructors |
  // +--------------+

  /**
   * Build a horizontal composition of two blocks.
   *
   * @param alignment The way in which the blocks should be aligned.
   * @param leftBlock The block on the left.
   * @param rightBlock The block on the right.
   */
  public HComp(VAlignment alignment, AsciiBlock leftBlock, AsciiBlock rightBlock) {
    this.align = alignment;
    this.blocks = new AsciiBlock[] {leftBlock, rightBlock};
  } // HComp(VAlignment, AsciiBlock, AsciiBlock)

  /**
   * Build a horizontal composition of multiple blocks.
   *
   * @param alignment The alignment of the blocks.
   * @param blocksToCompose The blocks we will be composing.
   */
  public HComp(VAlignment alignment, AsciiBlock[] blocksToCompose) {
    this.align = alignment;
    this.blocks = Arrays.copyOf(blocksToCompose, blocksToCompose.length);
    this.result = reduce();

  } // HComp(Alignment, AsciiBLOCK[])



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
  public AsciiBlock reduce() {
    AsciiBlock accumulator = new HorizontalCompositionTop(this.blocks[0], this.blocks[1]);
    for(int x = 2; x < this.blocks.length; x++){
      accumulator = new HorizontalCompositionTop(accumulator, this.blocks[x]);
    }
    return accumulator;
  } // row(int)




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
    return this.result.row(i);
  } // row(int)

  /**
   * Determine how many rows are in the block.
   *
   * @return the number of rows
   */
  public int height() {
  return this.result.height();
  } // height()

  /**
   * Determine how many columns are in the block.
   *
   * @return the number of columns
   */
  public int width() {
    return this.result.width();
  } // width()
   

  /**
   * Determine if another block is structurally equivalent to this block.
   *
   * @param other The block to compare to this block.
   *
   * @return true if the two blocks are structurally equivalent and false otherwise.
   */
  public boolean eqv(AsciiBlock other) {
    return false; // STUB
  } // eqv(AsciiBlock)
} // class HComp
