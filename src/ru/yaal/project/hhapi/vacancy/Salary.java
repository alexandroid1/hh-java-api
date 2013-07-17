package ru.yaal.project.hhapi.vacancy;

import lombok.Data;
import ru.yaal.project.hhapi.dictionary.Dictionaries;
import ru.yaal.project.hhapi.dictionary.DictionaryException;
import ru.yaal.project.hhapi.dictionary.Nullable;
import ru.yaal.project.hhapi.dictionary.entry.entries.currency.Currency;
import ru.yaal.project.hhapi.search.SearchException;
import ru.yaal.project.hhapi.search.parameter.ISearchParameter;
import ru.yaal.project.hhapi.search.parameter.SearchParamNames;
import ru.yaal.project.hhapi.search.parameter.SearchParameterBox;

@Data
public class Salary implements ISearchParameter, Nullable {
    public static final Salary NULL_SALARY = new Salary();
    private static final Integer NULL_VALUE = -1;
    private Integer from;
    private Integer to;
    private Currency currency = Currency.NULL_CURRENCY;

    public Salary() {
        setTo(NULL_VALUE);
        setFrom(NULL_VALUE);
    }

    public Salary(Integer from, Integer to) throws SearchException, DictionaryException {
        this(from, to, Dictionaries.getCurrency().getEntryById("RUR"));
    }

    public Salary(Integer from, Integer to, Currency currency) {
        setFrom(from);
        setTo(to);
        setCurrency(currency);
    }

    @Override
    public SearchParameterBox getSearchParameters() throws SearchException {
        SearchParameterBox params = new SearchParameterBox();
        if (from != null) {
            params.addParameter(SearchParamNames.SALARY, String.valueOf(from));
        } else {
            if (to != null) {
                params.addParameter(SearchParamNames.SALARY, String.valueOf(to));
            } else {
                throw new SearchException("�� �����������, �� ������������ �������� �� �������.");
            }
        }
        return params;
    }

    @Override
    public boolean isNull() {
        return (getTo() == NULL_VALUE || getFrom() == NULL_VALUE);
    }
}
