package org.thiki.kanban.acceptanceCriteria;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by xubt on 10/17/16.
 */
@Service
public class AcceptCriteriaService {

    @Resource
    private AcceptCriteriaPersistence acceptCriteriaPersistence;

    public AcceptanceCriteria addAcceptCriteria(String userName, String cardId, AcceptanceCriteria acceptanceCriteria) {

        acceptCriteriaPersistence.addAcceptCriteria(userName, cardId, acceptanceCriteria);
        return acceptCriteriaPersistence.findById(acceptanceCriteria.getId());
    }

    public List<AcceptanceCriteria> loadAcceptanceCriteriasByCardId(String cardId) {
        List<AcceptanceCriteria> acceptanceCriterias = acceptCriteriaPersistence.loadAcceptanceCriteriasByCardId(cardId);
        return acceptanceCriterias;
    }

    public AcceptanceCriteria loadAcceptanceCriteriaById(String acceptanceCriteriaId) {
        return acceptCriteriaPersistence.findById(acceptanceCriteriaId);
    }

    public AcceptanceCriteria updateAcceptCriteria(String acceptanceCriteriaId, AcceptanceCriteria acceptanceCriteria) {
        acceptCriteriaPersistence.updateAcceptCriteria(acceptanceCriteriaId, acceptanceCriteria);
        return acceptCriteriaPersistence.findById(acceptanceCriteriaId);
    }

    public Integer removeAcceptanceCriteria(String acceptanceCriteriaId) {
        return acceptCriteriaPersistence.deleteAcceptanceCriteria(acceptanceCriteriaId);
    }

    public List<AcceptanceCriteria> resortAcceptCriterias(String cardId, List<AcceptanceCriteria> acceptanceCriterias) {
        for (AcceptanceCriteria acceptanceCriteria : acceptanceCriterias) {
            acceptCriteriaPersistence.resort(acceptanceCriteria);
        }
        return acceptCriteriaPersistence.loadAcceptanceCriteriasByCardId(cardId);
    }
}
