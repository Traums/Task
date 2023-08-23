package example1;

interface HeroBuilder{
    HeroBuilder setId(long id);
    HeroBuilder setName(String name);
    HeroBuilder setLevel(int level);
    HeroBuilder setUltimate(String ultimate);
    Hero build();
}
