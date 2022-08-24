import React, { lazy, Suspense } from "react";
import { render } from "react-dom";
import { BrowserRouter, Routes, Route } from "react-router-dom";
import "antd-mobile/dist/antd-mobile.min.css";
import "antd/dist/antd.css";

const ClientPage = lazy(() => import("./client"));
const AdminPage = lazy(() => import("./admin"));

const AsyncComponent = (C) => (
  <Suspense fallback={<div>loading...</div>} children={<C />} />
);

const App = () => {
  return (
    <BrowserRouter>
      <Routes>
        <Route path="/index" element={AsyncComponent(ClientPage)} />
        <Route path="/admin" element={AsyncComponent(AdminPage)} />
      </Routes>
    </BrowserRouter>
  );
};

render(<App />, document.getElementById("app"));
