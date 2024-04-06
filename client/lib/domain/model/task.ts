export interface Task {
  id: number;
  title: string;
  description: string;
  owner: string;
  status: string;
  assignees: string[];
}
