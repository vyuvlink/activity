export const parseSearchParams = (search: string) =>
  search
    .replace("?", "")
    .split("&")
    .filter(Boolean)
    .reduce((res, curr) => {
      const [key, value] = curr.split("=");
      res[key] = value;
      return res;
    }, {}) || {};
