import React, { useEffect, useState } from "react";
import { PullToRefresh, List } from "antd-mobile";
import "./index.scss";

const App = () => {
  const [refreshing, setRefreshing] = useState(false);
  const [data, setData] = useState([]);

  const getData = () => {};

  const onRefresh = () => {
    setRefreshing(true);
    setTimeout(() => {
      setRefreshing(false);
    }, 500);
  };

  useEffect(() => {}, []);

  return (
    <div className="seckill-containerr">
      <PullToRefresh onRefresh={onRefresh}>
        <List>
          {data.map((item, index) => (
            <List.Item key={index}>{item}</List.Item>
          ))}
        </List>
      </PullToRefresh>
    </div>
  );
};

export default App;
