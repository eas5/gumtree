package com.github.gumtreediff.test;

import com.github.gumtreediff.io.TreeIoUtils;
import com.github.gumtreediff.tree.ITree;
import com.github.gumtreediff.tree.Pair;

import java.io.IOException;

public class TreeLoader {

    private TreeLoader() {}

    public static Pair<ITree, ITree> getActionPair() {
        return new Pair<>(load("/action_v0.xml"), load("/action_v1.xml"));
    }

    public static Pair<ITree, ITree> getZsCustomPair() {
        return new Pair<>(load("/zs_v0.xml"), load("/zs_v1.xml"));
    }

    public static Pair<ITree, ITree> getZsSlidePair() {
        return new Pair<>(load("/zs_slide_v0.xml"), load("/zs_slide_v1.xml"));
    }

    public static Pair<ITree, ITree> getDummyPair() {
        return new Pair<>(load("/Dummy_v0.xml"), load("/Dummy_v1.xml"));
    }

    public static ITree getDummySrc() {
        return load("/Dummy_v0.xml");
    }

    public static ITree getDummyDst() {
        return load("/Dummy_v1.xml");
    }

    public static ITree getDummyBig() {
        return load("/Dummy_big.xml");
    }

    public static ITree load(String name) {
        try {
            return TreeIoUtils.fromXml().generateFromStream(System.class.getResourceAsStream(name)).getRoot();
        } catch (IOException e) {
            throw new RuntimeException(String.format("Unable to load test ressorce: %s", name), e);
        }
    }
}
