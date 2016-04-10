package com.makarevich.dao;

import com.makarevich.model.Comment;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("commentDao")
public class CommentDaoImpl extends AbstractDao<Integer, Comment> implements CommentDao{
    public Comment findById(int id) { return getByKey(id); }

    public void saveComment(Comment comment) {
        persist(comment);
    }

    public void deleteCommentById(int id) {
        Query query = getSession().createSQLQuery("delete from COMMENT where id = :id");
        query.setInteger("id", id);
        query.executeUpdate();
    }

    @SuppressWarnings("unchecked")
    public List<Comment> findAllComments() {
        Criteria criteria = createEntityCriteria();
        return (List<Comment>) criteria.list();
    }

    public Comment findTeamById(int id) {
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("id", id));
        return (Comment) criteria.uniqueResult();
    }
}
