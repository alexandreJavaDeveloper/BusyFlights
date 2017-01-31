package com.travix.model;

public enum Supplier
{
    CRAZY_AIR(1, "CrazyAir"), TOUGH_JET(2, "ToughJet");

    private int id;

    private String name;

    private Supplier(final int id, final String name)
    {
        this.id = id;
        this.name = name;
    }

    public int getId()
    {
        return this.id;
    }

    public String getName()
    {
        return this.name;
    }
}