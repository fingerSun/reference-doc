# FOR UPDATE
```sql
 select * from t for update
```
  会等待行锁释放之后，返回查询结果。
  
```sql
 select * from t for update nowait 
```
 不等待行锁释放，提示锁冲突，不返回结果
 
```sql
 select * from t for update wait 5 
```
 等待5秒，若行锁仍未释放，则提示锁冲突，不返回结果
 
```sql
 select * from t for update skip locked 
```
 查询返回查询结果，但忽略有行锁的记录
 
# 小贴士：
 使用for update时，一定需要注意什么时候进行事务提交或回滚，如果没有事务处理，将会造成一直锁表，无限等待。 