package com.msetteducati.y2023.d8;

import lombok.Builder;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

@Builder
public class WastelandTraverser {
    private List<Direction> directions;
    private WastelandTreeNode[] roots;
    private Function<WastelandTreeNode, Boolean> isTerminalFunction;

    public long traverse() {
        long[] stepsToTerminal = new long[roots.length];
        Arrays.fill(stepsToTerminal, 0);

        for (int i = 0; i < roots.length; i++)  {
            stepsToTerminal[i] = traverseSingleRoot(roots[i]);
        }

        return com.msetteducati.util.Math.lcm(stepsToTerminal);
    }

    private long traverseSingleRoot(WastelandTreeNode root) {
        int steps = 0;
        for (int i = 0; ; i++) {
            if (this.isTerminalFunction.apply(root)) {
                return steps;
            }

            Direction direction = directions.get(i % directions.size());
            root = direction.traverse(root);
            steps++;
        }
    }
    public static WastelandTraverser fromInput(List<String> input) {
        return WastelandTraverser.fromInputHelper(input,
                WastelandTreeBuilder::buildFromInput,
                WastelandTreeNode::isTerminal);
    }

    public static WastelandTraverser fromInputForGhosts(List<String> input) {
        return WastelandTraverser.fromInputHelper(input,
                WastelandTreeBuilder::buildFromInputForGhosts,
                WastelandTreeNode::isTerminalForGhost);
    }

    private static WastelandTraverser fromInputHelper(List<String> input,
                                                      Function<List<String>, List<WastelandTreeNode>> getRootNodesFunction,
                                                      Function<WastelandTreeNode, Boolean> isTerminalFunction) {
        List<Direction> directions = input.get(0).chars()
                .mapToObj(c -> (char) c)
                .map(Direction::fromChar)
                .toList();

        List<WastelandTreeNode> roots = getRootNodesFunction.apply(input.subList(2, input.size()));

        return WastelandTraverser.builder()
                .directions(directions)
                .roots(roots.toArray(WastelandTreeNode[]::new))
                .isTerminalFunction(isTerminalFunction)
                .build();
    }
}
