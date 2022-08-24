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

const aesCrypto = (
  secretKey: string,
  config = {
    mode: CryptoJS.mode.ECB,
    padding: CryptoJS.pad.Pkcs7,
  }
) => {
  const encrypt = (data: string) =>
    CryptoJS.AES.encrypt(data, secretKey, config).toString();

  const decrypt = (encrypted: string) =>
    CryptoJS.AES.decrypt(encrypted, secretKey, config).toString(
      CryptoJS.enc.Utf8
    );

  return {
    encrypt,
    decrypt,
  };
};

//DES加密
function encryptByDES(message, key) {
  const keyHex = CryptoJS.enc.Utf8.parse(key);
  const encrypted = CryptoJS.DES.encrypt(message, keyHex, {
    mode: CryptoJS.mode.ECB,
    padding: CryptoJS.pad.Pkcs7,
  });
  return encrypted.ciphertext.toString();
}
//DES解密
function decryptByDES(ciphertext, key) {
  const keyHex = CryptoJS.enc.Utf8.parse(key);
  const decrypted = CryptoJS.DES.decrypt(
    {
      ciphertext: CryptoJS.enc.Hex.parse(ciphertext),
    },
    keyHex,
    {
      mode: CryptoJS.mode.ECB,
      padding: CryptoJS.pad.Pkcs7,
    }
  );
  const result_value = decrypted.toString(CryptoJS.enc.Utf8);
  return result_value;
}

const App = () => {
  const { search } = useLocation();
  const { scene }: any = parseSearchParams(search);
  const [loading, setLoading] = useState(true);
  const [pageType, setPageType] = useState();
  const Page = (pageType === "list" && ListPage) ||
    (pageType === "act" && ActPage) || <></>;

  useEffect(() => {
    const value = `{"activity_id":"8250480325095387136"}`;
    const key = "act_scene";
    const encode = encryptByDES(value, key);

    // console.log(md5(value));
    console.log(md5("123456"));

    console.log(encode);
    console.log(encode.length);

    // if (scene) {
    //   decodeSence({ scene })
    //     .then(({}) => {})
    //     .catch(() => {});
    // } else {
    //   setPageType("list");
    //   setLoading(false);
    // }
  }, []);

  if (loading) {
    return <ActivityIndicator toast text="加载中..." />;
  }

  return <Page />;
};

export default App;
