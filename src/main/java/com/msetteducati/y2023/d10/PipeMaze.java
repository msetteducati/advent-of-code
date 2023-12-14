package com.msetteducati.y2023.d10;

import com.msetteducati.model.PuzzleSolution;

import java.util.List;

public class PipeMaze implements PuzzleSolution {

    /**
     * You use the hang glider to ride the hot air from Desert Island all the way up to the floating metal island. This island is surprisingly cold and there definitely aren't any thermals to glide on, so you leave your hang glider behind.
     * <br><br>
     * You wander around for a while, but you don't find any people or animals. However, you do occasionally find signposts labeled "Hot Springs" pointing in a seemingly consistent direction; maybe you can find someone at the hot springs and ask them where the desert-machine parts are made.
     * <br><br>
     * The landscape here is alien; even the flowers and trees are made of metal. As you stop to admire some metal grass, you notice something metallic scurry away in your peripheral vision and jump into a big pipe! It didn't look like any animal you've ever seen; if you want a better look, you'll need to get ahead of it.
     * <br><br>
     * Scanning the area, you discover that the entire field you're standing on is densely packed with pipes; it was hard to tell at first because they're the same metallic silver color as the "ground". You make a quick sketch of all of the surface pipes you can see (your puzzle input).
     * <br><br>
     * The pipes are arranged in a two-dimensional grid of tiles:
     * <ul>
     * <li>| is a vertical pipe connecting north and south.</li>
     * <li>- is a horizontal pipe connecting east and west.</li>
     * <li>L is a 90-degree bend connecting north and east.</li>
     * <li>J is a 90-degree bend connecting north and west.</li>
     * <li>7 is a 90-degree bend connecting south and west.</li>
     * <li>F is a 90-degree bend connecting south and east.</li>
     * <li>. is ground; there is no pipe in this tile.</li>
     * <li>S is the starting position of the animal; there is a pipe on this tile, but your sketch doesn't show what shape the pipe has.</li>
     * </ul>
     * Based on the acoustics of the animal's scurrying, you're confident the pipe that contains the animal is one large, continuous loop.
     * <br><br>
     * For example, here is a square loop of pipe:
     * <pre>
     * .....
     * .F-7.
     * .|.|.
     * .L-J.
     * .....
     * </pre>
     * If the animal had entered this loop in the northwest corner, the sketch would instead look like this:
     *<pre>
     * .....
     * .S-7.
     * .|.|.
     * .L-J.
     * .....
     * </pre>
     * In the above diagram, the S tile is still a 90-degree F bend: you can tell because of how the adjacent pipes connect to it.
     * <br><br>
     * Unfortunately, there are also many pipes that aren't connected to the loop! This sketch shows the same loop as above:
     *<pre>
     * -L|F7
     * 7S-7|
     * L|7||
     * -L-J|
     * L|-JF
     * </pre>
     * In the above diagram, you can still figure out which pipes form the main loop: they're the ones connected to S, pipes those pipes connect to, pipes those pipes connect to, and so on. Every pipe in the main loop connects to its two neighbors (including S, which will have exactly two pipes connecting to it, and which is assumed to connect back to those two pipes).
     * <br><br>
     * Here is a sketch that contains a slightly more complex main loop:
     *<pre>
     * ..F7.
     * .FJ|.
     * SJ.L7
     * |F--J
     * LJ...
     * </pre>
     * Here's the same example sketch with the extra, non-main-loop pipe tiles also shown:
     *<pre>
     * 7-F7-
     * .FJ|7
     * SJLL7
     * |F--J
     * LJ.LJ
     * </pre>
     * If you want to get out ahead of the animal, you should find the tile in the loop that is farthest from the starting position. Because the animal is in the pipe, it doesn't make sense to measure this by direct distance. Instead, you need to find the tile that would take the longest number of steps along the loop to reach from the starting point - regardless of which way around the loop the animal went.
     * <br><br>
     * In the first example with the square loop:
     *<pre>
     * .....
     * .S-7.
     * .|.|.
     * .L-J.
     * .....
     * </pre>
     * You can count the distance each tile in the loop is from the starting point like this:
     *<pre>
     * .....
     * .012.
     * .1.3.
     * .234.
     * .....
     * </pre>
     * In this example, the farthest point from the start is 4 steps away.
     * <br><br>
     * Here's the more complex loop again:
     *<pre>
     * ..F7.
     * .FJ|.
     * SJ.L7
     * |F--J
     * LJ...
     * </pre>
     * Here are the distances for each tile on that loop:
     *<pre>
     * ..45.
     * .236.
     * 01.78
     * 14567
     * 23...
     * </pre>
     * Find the single giant loop starting at S. How many steps along the loop does it take to get from the starting position to the point farthest from the starting position?
     * @param input
     * @return
     */
    @Override
    public long part1(List<String> input) {
        return PipeMap.fromInput(input).getFurtherPositionDistance();
    }
}
