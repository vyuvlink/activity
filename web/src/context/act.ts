import { createContext } from "react";

export type ActivityContextType = {
  id: string
}

export const ActivityContext = createContext<ActivityContextType | null>(null);
