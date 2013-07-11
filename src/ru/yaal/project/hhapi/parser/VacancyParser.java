package ru.yaal.project.hhapi.parser;

import ru.yaal.project.hhapi.search.VacanciesList;

public class VacancyParser extends AbstractParser<VacanciesList> {
    @Override
    public VacanciesList parse(String content) {
        return gson.fromJson(content, VacanciesList.class);
    }
}