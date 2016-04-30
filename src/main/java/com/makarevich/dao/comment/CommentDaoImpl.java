package com.makarevich.dao.comment;

import com.makarevich.dao.AbstractDao;
import com.makarevich.dao.comment.model.Comment;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("commentDao")
public class CommentDaoImpl extends AbstractDao<Long, Comment> implements CommentDao{
    public Comment findById(Long id) { return getByKey(id); }

    public void saveComment(Comment comment) {
        persist(comment);
    }

    public void deleteCommentById(Long id) {
        Query query = getSession().createSQLQuery("delete from COMMENT where id = :id");
        query.setLong("id", id);
        query.executeUpdate();
    }

    @SuppressWarnings("unchecked")
    public List<Comment> findAllComments() {
        Criteria criteria = createEntityCriteria();
        return (List<Comment>) criteria.list();
    }

    public Comment findTeamById(Long id) {
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("id", id));
        return (Comment) criteria.uniqueResult();
    }
}
