package ru.yaal.project.hhapi.search.parameter;

import ru.yaal.project.hhapi.search.SearchException;

import static java.lang.String.format;

public class Page implements ISearchParameter {
    public static final int MIN_PAGE = 1;
    private Integer page;

    public Page(Integer page) throws SearchException {
        setPage(page);
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) throws SearchException {
        if (page < MIN_PAGE) throw new SearchException(
                format("����� �������� � ���������� �� ����� ���� ������ %d. ������� %d.", MIN_PAGE, page));
        this.page = page;
    }

    @Override
    public SearchParameterBox getSearchParameters() throws SearchException {
        return new SearchParameterBox(SearchParamNames.PAGE, String.valueOf(getPage()));
    }

    @Override
    public String getSearchParameterName() {
        return "����� ��������";
    }

}
