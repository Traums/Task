package example1;

public class HeroBuilderImpl implements HeroBuilder {
    Hero hero = new Hero();

    @Override
    public HeroBuilder setId(long id) {
        hero.setId(id);
        return this;
    }

    @Override
    public HeroBuilder setName(String name) {
        hero.setName(name);
        return this;
    }

    @Override
    public HeroBuilder setLevel(int level) {
        hero.setLevel(level);
        return this;
    }

    @Override
    public HeroBuilder setUltimate(String ultimate) {
        hero.setUltimate(ultimate);
        return this;
    }

    @Override
    public Hero build() {
        return hero;
    }
}
