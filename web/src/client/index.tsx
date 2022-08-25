import "./index.scss";
import React, { useEffect, useState } from "react";
import { ActivityIndicator } from "antd-mobile";
import { useLocation } from "react-router";
import { parseSearchParams } from "../utils";
import { decodeSence } from "../services/client";
import ListPage from "./list";
import ActPage from "./act";
import md5 from "md5";
import CryptoJS from "crypto-js";

const App = () => {
  const { search } = useLocation();
  const { scene }: any = parseSearchParams(search);
  const [loading, setLoading] = useState(true);
  const [pageType, setPageType] = useState();
  const Page = (pageType === "list" && ListPage) ||
    (pageType === "act" && ActPage) || <></>;

  useEffect(() => {
    if (scene) {
      decodeSence({ scene })
        .then(({}) => {})
        .catch(() => {});
    } else {
      setPageType("list");
      setLoading(false);
    }
  }, []);

  if (loading) {
    return <ActivityIndicator toast text="加载中..." />;
  }

  return <Page />;
};

export default App;
