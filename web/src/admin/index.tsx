import "./index.scss";
import React, { useEffect, useState } from "react";
import { Button, Form, Input } from "antd";
import { Toast } from "antd-mobile";
import { Login } from "../services/admin";

const FormList = [
  {
    label: "手机号",
    name: "phone",
    rules: [{ required: true, message: "请输入手机号" }],
    placeholder: "请输入手机号",
  },
  {
    label: "密码",
    name: "password",
    rules: [{ required: true, message: "请输入密码" }],
    placeholder: "请输入密码",
  },
];

const App = () => {
  const [loading, setLoading] = useState(false);
  const [form] = Form.useForm();

  const onClick = () => {
    if (loading) {
      Toast.info("操作繁忙，请稍后再试！");
      return;
    }
    form.validateFields().then(() => {
      setLoading(true);
      Login(form.getFieldsValue())
        .then(() => {
          window.location.href = "/seckill/list";
        })
        .finally(() => setLoading(false));
    });
  };

  useEffect(() => {}, []);

  return (
    <div className="admin-containerr index">
      <Form form={form}>
        {FormList.map(({ label, name, placeholder, rules }) => (
          <Form.Item label={label} name={name} rules={rules}>
            <Input placeholder={placeholder} />
          </Form.Item>
        ))}
      </Form>
      <Button
        className="btn mt10"
        loading={loading}
        type="primary"
        htmlType="submit"
        onClick={onClick}
      >
        提交
      </Button>
    </div>
  );
};

export default App;
