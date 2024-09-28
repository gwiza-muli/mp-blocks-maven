package edu.grinnell.csc207.blocks;

import java.util.Arrays;

/**
 * The vertical composition of blocks.
 *
 * @author Samuel A. Rebelsky
 * @author Your Name Here
 * @author Your Name Here
 */
public class VComp implements AsciiBlock {
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
  HAlignment align;

  /** the resulting H composition. */
    AsciiBlock result;

  // +--------------+------------------------------------------------------
  // | Constructors |
  // +--------------+

  /**
   * Build a vertical composition of two blocks.
   *
   * @param alignment
   *   The way in which the blocks should be aligned.
   * @param topBlock
   *   The block on the top.
   * @param bottomBlock
   *   The block on the bottom.
   */
  public VComp(HAlignment alignment, AsciiBlock topBlock,
      AsciiBlock bottomBlock) {
    this.align = alignment;
    this.blocks = new AsciiBlock[] {topBlock, bottomBlock};
    this.result = reduce();
  } // VComp(VAlignment, AsciiBlock, AsciiBlock)

  /**
   * Build a vertical composition of multiple blocks.
   *
   * @param alignment
   *   The alignment of the blocks.
   * @param blocksToCompose
   *   The blocks we will be composing.
   */
  public VComp(HAlignment alignment, AsciiBlock[] blocksToCompose) {
    this.align = alignment;
    this.blocks = Arrays.copyOf(blocksToCompose, blocksToCompose.length);
    this.result = reduce();
  } // VComp(VAlignment, AsciiBLOCK[])

  public AsciiBlock reduce() {
    AsciiBlock accumulator;
      if (this.align == HAlignment.LEFT) {
        accumulator = new VerticalCompositionLeft(this.blocks[0], this.blocks[1]);
      } else if (this.align == HAlignment.CENTER) {
        accumulator = new VerticalCompositionCenter(this.blocks[0], this.blocks[1]);
      } else if (this.align == HAlignment.RIGHT) {
        accumulator = new VerticalCompositionRight(this.blocks[0], this.blocks[1]);
      } else {
        throw new IllegalArgumentException("Invalid alignment");
      }

      for (int x = 2; x < this.blocks.length; x++) {
        if (this.align == HAlignment.LEFT) {
          accumulator = new VerticalCompositionLeft(accumulator, this.blocks[x]);
        } else if (this.align == HAlignment.CENTER) {
          accumulator = new VerticalCompositionCenter(accumulator, this.blocks[x]);
        } else if (this.align == HAlignment.RIGHT) {
          accumulator = new VerticalCompositionRight(accumulator, this.blocks[x]);
        } else {
          throw new IllegalArgumentException("Invalid alignment");
        }
      }

      return accumulator;
    }

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
   * @exception Exception
   *   if i is outside the range of valid rows.
   */
  public String row(int i) throws Exception {
   return this.result.row(i);  // STUB
  } // row(int)

  /**
   * Determine how many rows are in the block.
   *
   * @return the number of rows
   */
  public int height() {
    return this.result.height(); // STUB
  } // height()

  /**
   * Determine how many columns are in the block.
   *
   * @return the number of columns
   */
  public int width() {
    return this.result.width();   // STUB
  } // width()

  /**
   * Determine if another block is structurally equivalent to this block.
   *
   * @param other
   *   The block to compare to this block.
   *
   * @return true if the two blocks are structurally equivalent and
   *    false otherwise.
   */
  public boolean eqv(AsciiBlock other) {
   return false;
    //return this.result.eqv(other);      // STUB \\ MNtjsdfSDKLfjsdafbvgvgggggggggggggggggggggggggggggg
  } // eqv(AsciiBlock)
} // class VComp
