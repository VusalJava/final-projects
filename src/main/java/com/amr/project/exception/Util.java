package com.amr.project.exception;

import javax.persistence.NonUniqueResultException;
import javax.persistence.Query;
import javax.validation.constraints.NotNull;
import java.util.List;

public class Util {

    public static Object handlerSingleResult(@NotNull Query query) {
        List<?> results = query.setMaxResults(2).getResultList();
        if(results.size() > 1) throw new NonUniqueResultException();
        return results.isEmpty() ? null : results.get(0);
    }
}
