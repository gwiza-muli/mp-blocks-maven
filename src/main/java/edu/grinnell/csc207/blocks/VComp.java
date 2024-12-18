package edu.grinnell.csc207.blocks;

import java.util.Arrays;

/**
 * The vertical composition of blocks.
 *
 * @author Samuel A. Rebelsky
 * @author Mitch Paiva
 * @author Shiela Muligande
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
   * @param alignment The way in which the blocks should be aligned.
   * @param topBlock The block on the top.
   * @param bottomBlock The block on the bottom.
   */
  public VComp(HAlignment alignment, AsciiBlock topBlock, AsciiBlock bottomBlock) {
    this.align = alignment;
    this.blocks = new AsciiBlock[] {topBlock, bottomBlock};
    this.result = reduce();
  } // VComp(VAlignment, AsciiBlock, AsciiBlock)

  /**
   * Build a vertical composition of multiple blocks.
   *
   * @param alignment The alignment of the blocks.
   * @param blocksToCompose The blocks we will be composing.
   */
  public VComp(HAlignment alignment, AsciiBlock[] blocksToCompose) {
    this.align = alignment;
    this.blocks = Arrays.copyOf(blocksToCompose, blocksToCompose.length);
    this.result = reduce();
  } // VComp(VAlignment, AsciiBLOCK[])

  /**
   *
   * The reduce method applies the given composition onto the object.
   *
   * @return accumulator
   */
  public AsciiBlock reduce() {
    if (this.blocks.length == 0) {
      return new Empty();
    } // reduce ()
    AsciiBlock accumulator = this.blocks[0];
    if (accumulator.height() == 0 && accumulator.width() == 0) {
      accumulator = new Empty();
    } // if statement
    if (this.blocks.length > 1) {
      if (this.align == HAlignment.LEFT) {
        accumulator = new VerticalCompositionLeft(this.blocks[0], this.blocks[1]);
      } else if (this.align == HAlignment.CENTER) {
        accumulator = new VerticalCompositionCenter(this.blocks[0], this.blocks[1]);
      } else if (this.align == HAlignment.RIGHT) {
        accumulator = new VerticalCompositionRight(this.blocks[0], this.blocks[1]);
      } else {
        throw new IllegalArgumentException("Invalid alignment");
      } // else
      for (int x = 2; x < this.blocks.length; x++) {
        if (this.align == HAlignment.LEFT) {
          accumulator = new VerticalCompositionLeft(accumulator, this.blocks[x]);
        } else if (this.align == HAlignment.CENTER) {
          accumulator = new VerticalCompositionCenter(accumulator, this.blocks[x]);
        } else if (this.align == HAlignment.RIGHT) {
          accumulator = new VerticalCompositionRight(accumulator, this.blocks[x]);
        } else {
          throw new IllegalArgumentException("Invalid alignment");
        } // else
      } // for loop
    } // if statement
    return accumulator;
  } // reduce


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
    return ((other instanceof VComp) && (this.eqv((VComp) other)));
  } // eqv(AsciiBlock)

  /**
   * Determine if this VComp is structurally equivalent to another.
   *
   * @param other The block to compare to this block.
   *
   * @return true if the two blocks are structurally equivalent and false otherwise.
   */

  public boolean eqv(VComp other) {
    if (this.align != other.align) {
      return false;
    } // if statement
    if (this.blocks.length != other.blocks.length) {
      return false;
    } // if statement
    for (int i = 0; i < this.blocks.length; i++) {
      if (!AsciiBlock.eqv(this.blocks[i], other.blocks[i])) {
        return false;
      } // if statement
    } // for loop
    return true;
  } // eqv(HComp)
} // class VComp

