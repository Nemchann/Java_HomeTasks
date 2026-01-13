package com.nemchann.training.facade;

public class CoffeeMachineFacade {
    private GrinderSubsystem grinder;
    private BrewerSubsystem brewer;
    private MilkFrotherSubsystem frother;
    private CleanerSubsystem cleaner;

    public CoffeeMachineFacade() {
        this.grinder = new GrinderSubsystem();
        this.brewer = new BrewerSubsystem();
        this.frother = new MilkFrotherSubsystem();
        this.cleaner = new CleanerSubsystem();
    }

    public void makeEspresso() {
        grinder.grindBeans();
        brewer.brew();
        System.out.println("Эспрессо готов!");
    }

    public void makeCappuccino() {
        grinder.grindBeans();
        brewer.brew();
        frother.frothMilk();
        System.out.println("Капучино готов!");
    }

    public void cleanMachine() {
        cleaner.clean();
        System.out.println("Машина очищена");
    }
}
