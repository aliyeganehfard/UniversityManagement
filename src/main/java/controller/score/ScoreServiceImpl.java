package controller.score;

import controller.ServiceImpl;
import model.entity.Score;
import model.repository.score.ScoreRepositoryImpl;

public class ScoreServiceImpl extends ServiceImpl<ScoreRepositoryImpl, Score, Integer> implements ScoreService {
    private ScoreRepositoryImpl scoreRepository;

    public ScoreServiceImpl() {
        super(new ScoreRepositoryImpl());
        scoreRepository = new ScoreRepositoryImpl();
    }
}
