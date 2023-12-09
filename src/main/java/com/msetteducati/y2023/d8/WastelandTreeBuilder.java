package com.msetteducati.y2023.d8;

import lombok.experimental.UtilityClass;

import java.util.*;
import java.util.function.Function;

@UtilityClass
public class WastelandTreeBuilder {

    public List<WastelandTreeNode> buildFromInput(List<String> input) {
        return buildFromInputHelper(input, WastelandTreeNode::isRoot);
    }

    public List<WastelandTreeNode> buildFromInputForGhosts(List<String> input) {
        return buildFromInputHelper(input, WastelandTreeNode::isRootForGhost);
    }

    private List<WastelandTreeNode> buildFromInputHelper(List<String> input, Function<WastelandTreeNode, Boolean> isRootFunction) {
        Map<String, WastelandTreeNode> nodeMap = new HashMap<>();
        Set<WastelandTreeNode> roots = new HashSet<>();

        for (String str : input) {
            // Get labels
            String label = str.substring(0, 3);
            String leftLabel = str.substring(7, 10);
            String rightLabel = str.substring(12, 15);

            // Get or create nodes
            WastelandTreeNode node = nodeMap.getOrDefault(label, new WastelandTreeNode(label));
            WastelandTreeNode leftNode = nodeMap.getOrDefault(leftLabel, new WastelandTreeNode(leftLabel));
            WastelandTreeNode rightNode = leftLabel.equals(rightLabel) ? leftNode // account for both labels point to same node
                    : nodeMap.getOrDefault(rightLabel, new WastelandTreeNode(rightLabel));

            // Connect the nodes
            node.setLeft(leftNode);
            node.setRight(rightNode);

            // Store nodes in nodeMap
            nodeMap.put(node.getLabel(), node);
            nodeMap.put(leftNode.getLabel(), leftNode);
            nodeMap.put(rightNode.getLabel(), rightNode);

            if (isRootFunction.apply(node)) {
                roots.add(node);
            }
        }

        return roots.stream().toList();
    }

}
